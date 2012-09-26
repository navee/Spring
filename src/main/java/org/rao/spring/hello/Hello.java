package org.rao.spring.hello;

public class Hello {
	private String msg;
	
	public Hello(){
		this.msg = "Hello()";
	}
	
	public Hello(String msg){
		this.msg = msg;
	}
	
	public void sayHello(){
		System.out.println(msg);
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
