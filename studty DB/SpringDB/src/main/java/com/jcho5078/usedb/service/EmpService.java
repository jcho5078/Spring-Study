package com.jcho5078.usedb.service;

import java.util.List;

import com.jcho5078.usedb.vo.EmpVO;

public interface EmpService {

	List<EmpVO> viewEmp();
	void insertEmp(EmpVO empVO);
}
