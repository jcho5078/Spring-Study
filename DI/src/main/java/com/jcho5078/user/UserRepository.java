package com.jcho5078.user;

import java.util.HashMap;
import java.util.List;

public class UserRepository {
	private HashMap<String, UserVO> userMap = new HashMap<String, UserVO>();
	
	public UserVO findUserById(String id) {
		return userMap.get(id);
	}
	
	public void setUser(List<UserVO> user) {
		for(UserVO u : user) {
			userMap.put(u.getId(), u);
			System.out.println(u.getId()); //확인용 출력
		}
	}
}
