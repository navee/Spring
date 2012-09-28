package org.rao.spring.orm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/hibernate/applicationContext.xml");
		SessionFactory sf = ctx.getBean("sessionFactory",SessionFactory.class);
		Session session = sf.openSession();
		System.out.println(session);
	}
}
