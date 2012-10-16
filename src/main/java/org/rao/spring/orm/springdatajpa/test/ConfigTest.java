package org.rao.spring.orm.springdatajpa.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:org/rao/spring/orm/springdatajpa/applicationContext.xml"})
public class ConfigTest {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void testConfig(){
		System.out.println("==========" + entityManager);
	}
}
