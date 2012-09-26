package org.rao.spring.aop;

public class HelloAspect {
	public void beforeActive(){
		System.out.println("before active");
	}

	public void afterActive() {
		System.out.println("after active");
	}
}
