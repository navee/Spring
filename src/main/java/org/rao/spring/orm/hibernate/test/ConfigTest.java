package org.rao.spring.orm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.rao.spring.orm.hibernate.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/hibernate/applicationContext.xml");
		SessionFactory sf = ctx.getBean("sessionFactory",SessionFactory.class);
		Session session = sf.openSession();
		User user1 = new User();
		user1.setId(1);
		user1.setName("navee");
		session.beginTransaction();
		session.save(user1);
		session.getTransaction().commit();
		session.beginTransaction();
		User user2 = (User) session.get(User.class,1);
		session.getTransaction().commit();
		System.out.println(user2.getId() + " " + user2.getName());
	}
}
