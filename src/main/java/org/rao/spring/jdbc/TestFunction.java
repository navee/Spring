package org.rao.spring.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.hsqldb.Types;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * @author rao 测试自定义函数调用 存储过程
 */
public class TestFunction {
	private static JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void setDatabase() {
		String url = "jdbc:hsqldb:mem:test";
		String username = "sa";
		String password = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Before
	public void setTable() {
		//Only Hsqldb!
		String createTableSql = "create memory table test (id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, name varchar(100))";
		jdbcTemplate.update(createTableSql);
		
		String createFunctionSql = "create function function_test(str char(100)) return int begin atomic return length(str); end";
		jdbcTemplate.update(createFunctionSql);
		
		String createProcedureSql = "create procedure procedure_test(inout inOutName varchar(100),out outId int) "+
				"MODIFIES SQL DATA " +  
			      "BEGIN ATOMIC " +  
			      "  insert into test(name) values (inOutName); " +  
			      "  SET outId = IDENTITY(); " +  
			      "  SET inOutName = 'Hello,' + inOutName; " +  
			    "END";  
		jdbcTemplate.update(createProcedureSql);
	}
	
    @After  
    public void tearDown() {  
        jdbcTemplate.execute("DROP FUNCTION FUNCTION_TEST");  
        jdbcTemplate.execute("DROP PROCEDURE PROCEDURE_TEST");  
        String dropTableSql = "drop table test";  
        jdbcTemplate.execute(dropTableSql);  
    }  
}
