package com.jcho5078.user;

public class UserVO {
	private String userId;
	private String userPw;
	//dao구현 후 DB값 불러올 예정
	public UserVO(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public String getId() {
		return userId;
	}
	
	public String getPw() {
		return userPw;
	}
}
