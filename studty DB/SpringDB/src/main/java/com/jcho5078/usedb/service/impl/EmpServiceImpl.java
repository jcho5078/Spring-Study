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

	@Override
	public void insertEmp(EmpVO empVO) {
		empDAO.insertEmp(empVO);
	}

	@Override
	public void deleteEmp(EmpVO empVO) {
		empDAO.deleteEmp(empVO);
	}

	@Override
	public void updateEmp(EmpVO empVO) {
		empDAO.updateEmp(empVO);
	}

	@Override
	public List<EmpVO> viewEmp2(EmpVO empVO) {
		return empDAO.viewEmp2(empVO);
	}
	
}
