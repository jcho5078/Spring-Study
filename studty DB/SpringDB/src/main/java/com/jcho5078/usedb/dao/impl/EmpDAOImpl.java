package com.jcho5078.usedb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcho5078.usedb.dao.EmpDAO;
import com.jcho5078.usedb.vo.EmpVO;

public class EmpDAOImpl extends SqlSessionDaoSupport implements EmpDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<EmpVO> viewEmp() {
		
		return getSqlSession().selectList("emp.viewEmp");
	}

	@Override
	public void insertEmp(EmpVO empVO) {
		System.out.println("DAO insert 실행 확인.");
		sqlSession.insert("emp.insertEmp", empVO);
	}

	@Override
	public void deleteEmp(EmpVO empVO) {
		System.out.println("DAO delete 실행 확인.");
		sqlSession.delete("emp.deleteEmp", empVO);
	}

	@Override
	public void updateEmp(EmpVO empVO) {
		System.out.println("DAO update 실행 확인.");
		sqlSession.update("emp.updateEmp", empVO);
	}

	@Override
	public List<EmpVO> viewEmp2(EmpVO empVO) {
		return sqlSession.selectList("emp.viewEmp", empVO);
	}
	
	
}
