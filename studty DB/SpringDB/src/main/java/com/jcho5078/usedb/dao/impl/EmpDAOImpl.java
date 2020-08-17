package com.jcho5078.usedb.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.jcho5078.usedb.dao.EmpDAO;
import com.jcho5078.usedb.vo.EmpVO;

public class EmpDAOImpl extends SqlSessionDaoSupport implements EmpDAO{

	@Override
	public List<EmpVO> viewEmp() {
		
		return getSqlSession().selectList("emp.viewEmp");
	}

}
