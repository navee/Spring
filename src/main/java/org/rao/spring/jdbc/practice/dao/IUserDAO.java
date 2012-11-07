package org.rao.spring.jdbc.practice.dao;

import java.util.List;

import org.rao.spring.jdbc.practice.entity.User;

public interface IUserDAO {
	void save(User user);
	int countAll();
	User findById(Integer id);
	List<User> findAll();
}
