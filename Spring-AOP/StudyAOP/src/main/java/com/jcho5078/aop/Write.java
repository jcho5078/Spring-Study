package com.jcho5078.aop;

public class Write {
	private String str;
	
	public Write(String str) {
		this.str = str;
	}
	
	public void writeStr() {
		System.out.println(str);
	}
}
