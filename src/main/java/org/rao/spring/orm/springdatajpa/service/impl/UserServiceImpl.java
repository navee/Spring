package org.rao.spring.orm.springdatajpa.service.impl;

import org.rao.spring.orm.springdatajpa.dao.UserDao;
import org.rao.spring.orm.springdatajpa.entity.User;
import org.rao.spring.orm.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

}
