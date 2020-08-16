package com.my.web.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.my.web.dao.EmpDAO;
import com.my.web.vo.EmpVO;

@Component
public class EmpDAOImpl extends SqlSessionDaoSupport implements EmpDAO{

	@Override
	public List<EmpVO> getEmpList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("emp.getEmpList");
	}

	
	

}
