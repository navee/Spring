package org.rao.spring.orm.hibernate.dao.impl;

import org.rao.spring.orm.hibernate.dao.UserDao;
import org.rao.spring.orm.hibernate.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao{

}
