package org.rao.spring.orm.hibernate.test;

import org.junit.Assert;
import org.junit.Test;
import org.rao.spring.orm.hibernate.entity.User;
import org.rao.spring.orm.hibernate.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
	@Test
	public void testService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/hibernate/applicationContext.xml");
		UserService userService = ctx.getBean(UserService.class);
		User u1 = new User();
		u1.setId(1);
		u1.setName("name1");
		userService.save(u1);
		Assert.assertNotNull(userService.get(1));
		User u2 = new User();
		u2.setId(2);
		u2.setName("name2");
		userService.save(u2);
		Assert.assertEquals(2, userService.list().size());
		User u3 = userService.get(1);
		u3.setName("name3");
		userService.update(u3);
		Assert.assertEquals("name3", userService.get(1).getName());
		userService.delete(userService.get(1));
		Assert.assertEquals(1, userService.list().size());
	}
}
