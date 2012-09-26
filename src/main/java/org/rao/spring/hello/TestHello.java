package org.rao.spring.hello;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class TestHello {
	@Test
	public void test(){
		Logger log = Logger.getLogger(TestHello.class);
		BeanFactory bf = new ClassPathXmlApplicationContext("org/rao/spring/hello/Hello.xml");
		Hello hello1 = bf.getBean("hello1",Hello.class);
		hello1.sayHello();
		Hello hello2 = bf.getBean("hello2",Hello.class);
		hello2.sayHello();
		Hello hello3 = bf.getBean("hello3",Hello.class);
		hello3.sayHello();
		
		Hello hello4 = bf.getBean("hello4",Hello.class);
		hello4.sayHello();
	}
	
	@Test
	public void testXmlReader(){
		//通过文件系统获取xml配置
		File xmlFile = new File("Hello.xml");
		Resource resource = new FileSystemResource(xmlFile);
		BeanFactory bf = new XmlBeanFactory(resource);
		//another way
		bf = new FileSystemXmlApplicationContext("Hello.xml");
		Hello hello1 = bf.getBean("hello1",Hello.class);
		hello1.sayHello();
		
		//通过classpath获取文件配置
	}
}
