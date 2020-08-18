package com.jcho5078.usedb.dao;

import java.util.List;

import com.jcho5078.usedb.vo.EmpVO;

public interface EmpDAO {

	public List<EmpVO> viewEmp();
	public void insertEmp(EmpVO empVO);
}
