package org.rao.spring.orm.jpa.test;

import org.junit.Test;
import org.rao.spring.orm.jpa.entity.User;
import org.rao.spring.orm.jpa.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/jpa/applicationContext.xml");
		UserService userSercice = ctx.getBean(UserService.class);
		User u1 = new User();
		u1.setId(1);
		u1.setName("rao");
		userSercice.save(u1);
		User u2 = userSercice.findById(1);
		System.out.println(u2.getName());
	}
}
