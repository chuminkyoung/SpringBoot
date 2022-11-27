package spring.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration	// 1
public class AppCtx {
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); // 외우기
		ds.setUrl("jdbc:mysql://localhost:3306/madang");  // 데이타베이스 연결
		ds.setUsername("root");
		ds.setPassword("aA!123456");
		
		// 커넥션 풀 설정
		ds.setInitialSize(2);								// 처음 생성되는 커넥션 풀 갯수, 기본값은 10개
		ds.setMaxActive(10); 								// 최대한 생성되는 커넥션 풀 갯수, 기본값 100개
		
		// 커넥션 풀이 DB와 연결이 정상적인지 체크
		ds.setTestWhileIdle(true);							// 커넥션풀이 대기 상태일 때 연결 체크 테스트
		ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);	// 커넥션풀이 최대한 대기 할 수 있는 시간
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10);		// 커넥션 풀 체크 주기 -10초
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		
		return jdbcTemplate;
	}
}
