package org.rao.spring.orm.springdatajpa.dao;

import java.util.List;

import org.rao.spring.orm.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends Repository<User, String> {
	public User save(User user);
	
	public User findByName(String name);

	public User findById(String id);
	
	public long count();
	
	public List<User> findAll();
}
