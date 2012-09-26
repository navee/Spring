package org.rao.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("org/rao/spring/aop/spring.xml");
		IHelloServer helloServer = ac.getBean("helloServer",IHelloServer.class);
		helloServer.sayHello();
	}
}
