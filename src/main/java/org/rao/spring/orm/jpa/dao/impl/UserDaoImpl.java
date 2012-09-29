package org.rao.spring.orm.jpa.dao.impl;

import org.rao.spring.orm.jpa.dao.UserDao;
import org.rao.spring.orm.jpa.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

}
