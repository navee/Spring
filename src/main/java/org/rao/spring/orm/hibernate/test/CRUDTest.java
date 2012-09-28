package org.rao.spring.orm.hibernate.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.rao.spring.orm.hibernate.dao.UserDao;
import org.rao.spring.orm.hibernate.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CRUDTest {
	@Test
	public void testCrud(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/hibernate/applicationContext.xml");
		UserDao dao = ctx.getBean(UserDao.class);
		//create
		User user = new User();
		user.setId(1);
		user.setName("rao");
		dao.save(user);
		//read
		User user2 = dao.findById(1);
		Assert.assertNotNull(user2);
		User user3 = new User();
		user3.setName("navee");
		dao.save(user3);
		//read
		Assert.assertEquals(2, dao.findAll().size());
		//update
		User user4 = dao.findById(1);
		user4.setName("raozhh");
		dao.update(user4);
		Assert.assertEquals("raozhh", dao.findById(1).getName());
		//delete
		dao.delete(dao.findById(1));
		Assert.assertEquals(1, dao.findAll().size());
	}
}
