package org.rao.spring.jdbc;
/**
 * 测试基本CRUD
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestCRUD {
	private static JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void setDatabase() {
		String url = "jdbc:hsqldb:mem:test";
//		String url = "jdbc:h2:~/test";
		String username = "sa";
		String password = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
//		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Before
	public void createTable() {
		String createTableSql = "create memory table test" + "(id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, " + "name varchar(100))";
		jdbcTemplate.update(createTableSql);
	}

	@After
	public void dropTable() {
		String dropTableSql = "drop table test";
		jdbcTemplate.execute(dropTableSql);
	}

	@Test
	public void testCRUD() {
		insert();
		update();
		select();
		delete();
	}

	private void select() {
		jdbcTemplate.query("select * from test", new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			}
		});
	}

	private void update() {
		jdbcTemplate.update("update test set name='name3' where name=?", new Object[] { "name1" });
		Assert.assertEquals(1, jdbcTemplate.queryForInt("select count(*) from test where name='name3'"));
	}

	private void delete() {
		jdbcTemplate.update("delete from test where name = ?", new Object[] { "name1" });
		Assert.assertEquals(0, jdbcTemplate.queryForInt("select count(*) from test where name = 'name1'"));
	}

	private void insert() {
		jdbcTemplate.update("insert into test(name) values('name1')");
		jdbcTemplate.update("insert into test(name) values('name2')");
		Assert.assertEquals(2, jdbcTemplate.queryForInt("select count(*) from test"));
	}
}
