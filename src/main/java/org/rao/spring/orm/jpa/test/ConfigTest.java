package org.rao.spring.orm.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.rao.spring.orm.jpa.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("org/rao/spring/orm/jpa/applicationContext.xml");
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		EntityManager em = entityManagerFactory.createEntityManager();
		User u1 = new User();
		u1.setId(1);
		u1.setName("rao1");
		em.getTransaction().begin();
		em.persist(u1);
		em.getTransaction().commit();
		User u2 = em.createQuery("from User u where u.id = 1",User.class).getSingleResult();
		System.out.println(u2.getId() + " " + u2.getName());
	}
}
