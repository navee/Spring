package org.rao.spring.jdbc.practice.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rao.spring.jdbc.practice.dao.IUserDAO;
import org.rao.spring.jdbc.practice.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcTemplate {
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testDao(){
		String[] configs = new String[]{"classpath:/org/rao/spring/jdbc/practice/applicationContext-resources.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		IUserDAO userDao = ctx.getBean(IUserDAO.class);
		User user = new User();
		user.setId(1);
		user.setName("User1");
		userDao.save(user);
		Assert.assertEquals(1, userDao.countAll());
		User u = userDao.findById(1);
		System.out.println(u.getId() + " " + u.getName());
		List<User> uList = userDao.findAll();
		System.out.println(uList.size());
	}
}
