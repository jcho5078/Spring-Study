package com.jcho5078.usedb.service;

import java.util.List;

import com.jcho5078.usedb.vo.EmpVO;

public interface EmpService {

	List<EmpVO> viewEmp();
	List<EmpVO> viewEmp2(EmpVO empVO);
	void insertEmp(EmpVO empVO);
	void deleteEmp(EmpVO empVO);
	void updateEmp(EmpVO empVO);
}
