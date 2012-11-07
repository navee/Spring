package org.rao.spring.jdbc.practice.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMap implements RowMapper<User>{
	public User mapRow(ResultSet rs,int rowNum) throws SQLException{
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		return u;
	}
}
