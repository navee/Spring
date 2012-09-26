package org.rao.spring.jdbc.practice.dao;

import org.rao.spring.jdbc.practice.entity.User;

public interface IUserDAO {
	public void save(User user);
	public int countAll();
}
