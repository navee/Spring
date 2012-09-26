package org.rao.spring.hello;

public class HelloFactory {
	public static Hello newInstance(String msg){
		return new Hello(msg);
	}
}
