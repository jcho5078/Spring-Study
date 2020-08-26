package com.web.security.user.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.security.user.dao.UserDAO;
import com.web.security.user.vo.UserVO;

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<UserVO> selectUser(UserVO vo) {
		
		return sqlSession.selectList("user.viewUser", vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		
		sqlSession.insert("user.insertUser", vo);
	}

	@Override
	public void deleteUser(UserVO vo) {

		sqlSession.delete("user.deleteUser", vo);
	}

	@Override
	public void updateUser(UserVO vo) {

		sqlSession.update("user.updateUser", vo);
	}

	@Override
	public List<UserVO> getUserForm(String id) {
		
		return sqlSession.selectOne("user.getUserForm", id);
	}

}
