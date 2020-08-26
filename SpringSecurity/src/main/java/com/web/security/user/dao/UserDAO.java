package com.web.security.user.dao;

import java.util.List;

import com.web.security.user.vo.UserVO;

public interface UserDAO {
	
	public List<UserVO> selectUser(UserVO vo);
	public void insertUser(UserVO vo);
	public void deleteUser(UserVO vo);
	public void updateUser(UserVO vo);
	public List<UserVO> getUserForm(String id);
}
