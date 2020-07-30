package com.jcho5078.enviroment;

public class SetData {
	private String id;
	private String pw;
	
	public SetData(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public void print() {
		//System.out.println("자동 스캔:" + environment.getProperty("user.id"));
		
		System.out.println("@Value 스캔id:" + id);
		System.out.println("@Value 스캔pw:" + pw);
	}
	
	public void print2() {
		//System.out.println("자동 스캔:" + environment.getProperty("user.id"));
		
		System.out.println("Env.getProperty 스캔id:" + id);
		System.out.println("Env.getProperty 스캔pw:" + pw);
	}
}
