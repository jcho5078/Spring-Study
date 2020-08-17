package com.jcho5078.usedb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcho5078.usedb.dao.EmpDAO;
import com.jcho5078.usedb.service.EmpService;
import com.jcho5078.usedb.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpDAO empDAO;

	@Override
	public List<EmpVO> viewEmp() {
		
		return empDAO.viewEmp();
	}
	
	
}
