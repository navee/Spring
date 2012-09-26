package org.rao.spring.jdbc;

/**
 * 测试创建jdbc连接
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestJdbc {
	private static JdbcTemplate jdbcTemplate;
	@BeforeClass
	public static void setDatabase(){
		String url = "jdbc:hsqldb:mem:test";
		String username = "sa";
		String password = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url,username,password);
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Test
	public void testDatabase(){
		String sql = "select * from INFORMATION_SCHEMA.SYSTEM_TABLES";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				String value = rs.getString("table_name");
				System.out.println(value);
			}
		});
	}
}
