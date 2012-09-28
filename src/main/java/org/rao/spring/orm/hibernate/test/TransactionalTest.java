package org.rao.spring.orm.hibernate.test;

import org.junit.Assert;
import org.junit.Test;
import org.rao.spring.orm.hibernate.dao.UserDao;
import org.rao.spring.orm.hibernate.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionalTest {
	@Test
	public void testTransactional(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/hibernate/applicationContext.xml");
		UserDao dao = ctx.getBean(UserDao.class);
		User u = new User();
		u.setId(1);
		u.setName("aaa");
		dao.save(u);
//		User u1 = new User();
//		u1.setId(2);
//		u1.setName("aaa");
//		dao.save(u1);
		Assert.assertEquals(1, dao.findAll().size());
	}
}
