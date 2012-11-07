package org.rao.spring.jdbc.practice.dao.impl;

import java.util.List;

import org.rao.spring.jdbc.practice.dao.IUserDAO;
import org.rao.spring.jdbc.practice.entity.User;
import org.rao.spring.jdbc.practice.entity.UserRowMap;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO {
	public void save(User user) {
		this.getJdbcTemplate().update("insert into test(id,name) values(?,?)",new Object[] {user.getId(),user.getName()});
	}

	public int countAll() {
		return this.getJdbcTemplate().queryForInt("select count(*) from test");
	}
	
	@SuppressWarnings("unchecked")
	public User findById(Integer id){
		User u = this.getJdbcTemplate().queryForObject("select id,name from test where id = ?", new Object[]{id}, new UserRowMap());
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		return this.getJdbcTemplate().query("select id,name from test", new UserRowMap() );
	}
}
