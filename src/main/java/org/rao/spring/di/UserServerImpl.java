package org.rao.spring.di;

public class UserServerImpl implements IUserServer {
	private User user;
	
	public void printUser(){
		System.out.println(user.getName());
	}

	public void setUser(User user) {
		this.user = user;
	}
}
