package com.web.security.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.security.user.dao.UserDAO;
import com.web.security.user.service.UserService;
import com.web.security.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<UserVO> selectUser(UserVO vo) {
		
		return userDAO.selectUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		
		userDAO.insertUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		
		userDAO.deleteUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		
		userDAO.updateUser(vo);
	}

	@Override
	public UserVO getUserForm(String id) {
		
		return userDAO.getUserForm(id);
	}

	@Override
	public UserVO getUserFormForUserDetail(String id) throws Exception {//id 입력시 해당 id의 유저 정보 가져옴.
		
		return userDAO.getUserFormForUserDetail(id);
	}

	//유저의 개인정보 변경
	@Override
	public void updatePrivateUser(UserVO vo) {
		
		userDAO.updatePrivateUser(vo);
	}

}
