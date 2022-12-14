package controllers.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import models.file.FileInfo;
import models.file.FileInfoDao;

@RestController
public class DownloadController {
	
	
	@Value("${file.uploadPath}")
	private String uploadPath;
	
	@Autowired
	private FileInfoDao fileInfoDao;
	
	@GetMapping("/file/download/{id}")
	public void download(@PathVariable long id, HttpServletResponse response) {
		try {
			FileInfo fileInfo = fileInfoDao.get(id);
			if(fileInfo == null) {
				throw new RuntimeException("파일이 존재하지 않습니다.");
			}
			
			String filePath = uploadPath + "/" + (id % 10) + "/" + id;
			File file = new File(filePath);
			if(!file.exists()) {
				throw new RuntimeException("파일이 존재하지 않습니다.");
			}
			
			String fileName = fileInfo.getFileName(); // 원본 파일 명
			fileName = new String(fileName.getBytes(), "ISO8859_1"); // EUC-KR
			
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.setHeader("Content-Type", "application/octet-stream");
			response.setIntHeader("Expires", 0);	// 페이지 만료 x
			response.setHeader("Cache-Control", "must-revalidate");
			response.setHeader("Pragma", "public");
			response.setHeader("Content-Length", "" + file.length());
			
			OutputStream out = response.getOutputStream();
			
			try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis)){
				int i = 0;
				while((i = bis.read()) != -1) {
					out.write(i);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
