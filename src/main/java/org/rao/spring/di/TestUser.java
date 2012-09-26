package org.rao.spring.di;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
	@Test
	public void test(){
		BeanFactory bf = new ClassPathXmlApplicationContext("org/rao/spring/di/spring.xml");
		IUserServer userServer = bf.getBean("userServer",IUserServer.class);
		userServer.printUser();
	}
}
