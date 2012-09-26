package org.rao.spring.jdbc.practice.dao.impl;

import org.rao.spring.jdbc.practice.dao.IUserDAO;
import org.rao.spring.jdbc.practice.entity.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO {
	public void save(User user) {
		this.getJdbcTemplate().update("insert into test(name) values(?)",new Object[] {user.getName()});
	}

	public int countAll() {
		return this.getJdbcTemplate().queryForInt("select count(*) from test");
//		return 1;
	}

}
