package org.rao.spring.orm.springdatajpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rao.spring.orm.springdatajpa.dao.UserDao;
import org.rao.spring.orm.springdatajpa.entity.User;
import org.rao.spring.orm.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:org/rao/spring/orm/springdatajpa/applicationContext.xml" })
public class CRUDTest {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;

	@Test
	public void doTest() {
		User u = new User();
		// u.setId("1");
		u.setName("rao");
		u.setAge(22);
		u.setSex(true);
		System.out.println("--------save--------");
		userDao.save(u);
		System.out.println("--------count--------");
		userDao.count();
		System.out.println("--------findall--------");
		userDao.findAll();
		System.out.println("--------findbyid--------");
		userDao.findById("1");
		System.out.println("--------findbyname--------");
		userDao.findByName("rao");
		// userDao.
		// System.out.println("count- :"+userDao.count());
		// User u1 = userDao.findOne("1");
		// System.out.println("findone :" + u1.getId() + " " + u1.getName());
		// User u2 = userDao.findByName("rao");
		// System.out.println("findbyname:" + u2.getId() + " " + u2.getName());
	}
	
	@Test
	public void testService(){
		System.out.println("=============testService=============");
		User u = userService.saveUser(new User());
		System.out.println(u.getId());
	}
}
