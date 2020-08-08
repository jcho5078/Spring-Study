package com.jcho5078.mvc.validate.annotation;

public class UserRegReq {
	
	private String name;
	
	public UserRegReq(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
