package models.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class FileInfoDao {
	
	private RowMapper<FileInfo> mapper = (rs, i) -> {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setId(rs.getLong("id"));
		fileInfo.setGid(rs.getString("gid"));
		fileInfo.setFileName(rs.getString("fileName"));
		fileInfo.setFileType(rs.getString("fileType"));
		fileInfo.setSuccess(rs.getBoolean("success"));
		fileInfo.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
		return fileInfo;
	};

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public FileInfo register(FileInfo fileInfo) {	// 파일 등록
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO fileInfo (gid, fileName, fileType) VALUES (?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id"});	// 증감번호
				pstmt.setString(1, fileInfo.getGid());
				pstmt.setString(2, fileInfo.getFileName());
				pstmt.setString(3, fileInfo.getFileType());
				
				return pstmt;
			}
			
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		long id = keyValue.longValue();	// 증감번호
		
		return get(id);
	}
	
	public FileInfo get(long id) {	// 파일 조회
		try {
			String sql = "SELECT * FROM fileInfo WHERE id = ?";
			FileInfo fileInfo = jdbcTemplate.queryForObject(sql, mapper, id);
			
			return fileInfo;
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<FileInfo> gets(String gid) {	// 파일 목록
		String sql = "SELECT * FROM fileInfo WHERE gid = ? ORDER BY regDt";
		List<FileInfo> fileInfos = jdbcTemplate.query(sql, mapper, gid);
		
		return fileInfos;
	}
	
	public boolean remove(long id) {	// 파일 삭제
		String sql = "DELETE FROM fileInfo WHERE id = ?";
		int affectedRows = jdbcTemplate.update(sql, id);	// 삭제된 레코드가 있으면 1이상의 값
		
		return affectedRows > 0;
	}
	
	public boolean remove(String gid) {	// 파일 한번에 삭제
		String sql = "DELETE FROM fileInfo WHERE gid = ?";
		int affectedRows = jdbcTemplate.update(sql, gid);
		
		return affectedRows > 0;
	}
	
	// 작업 완료 처리
	public void updateDone(String gid) {
		String sql = "UPDATE fileInfo SET success = 1 WHERE gid = ?";
		jdbcTemplate.update(sql, gid);
	}
}
