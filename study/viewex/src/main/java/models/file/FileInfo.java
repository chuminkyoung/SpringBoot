package models.file;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FileInfo {
	private long id;
	private String gid;
	private String fileName;
	private String fileType;
	private boolean success;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime regDt;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public LocalDateTime getRegDt() {
		return regDt;
	}
	
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	
	@Override
	public String toString() {
		return "FileInfo [id=" + id + ", gid=" + gid + ", fileName=" + fileName + ", fileType=" + fileType
				+ ", success=" + success + ", regDt=" + regDt + "]";
	}
	
	
}
