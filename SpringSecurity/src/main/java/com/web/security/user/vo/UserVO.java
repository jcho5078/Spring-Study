package com.web.security.user.vo;

public class UserVO {
	
	private String id;
	private String pw;
	private String hiredate;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getDate() {
		return hiredate;
	}
	public void setDate(String date) {
		hiredate = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}