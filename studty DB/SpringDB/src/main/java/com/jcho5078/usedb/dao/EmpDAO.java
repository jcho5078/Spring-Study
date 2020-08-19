package com.jcho5078.usedb.dao;

import java.util.List;

import com.jcho5078.usedb.vo.EmpVO;

public interface EmpDAO {

	public List<EmpVO> viewEmp();
	public List<EmpVO> viewEmp2(EmpVO empVO);
	public void insertEmp(EmpVO empVO);
	public void deleteEmp(EmpVO empVO);
	public void updateEmp(EmpVO empVO);
}
