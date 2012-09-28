package org.rao.spring.orm.hibernate.service.impl;

import javax.annotation.Resource;

import org.rao.spring.orm.hibernate.dao.BaseDao;
import org.rao.spring.orm.hibernate.entity.User;
import org.rao.spring.orm.hibernate.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
	@Resource(name="userDao")
	public void setDao(BaseDao<User, Integer> dao){
		super.dao = dao;
	}
}
