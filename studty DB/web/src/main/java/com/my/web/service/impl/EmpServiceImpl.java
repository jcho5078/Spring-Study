package com.my.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.web.dao.EmpDAO;
import com.my.web.service.EmpService;
import com.my.web.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired EmpDAO empDAO;
	
	@Override
	public List<EmpVO> getEmpList() {
		// TODO Auto-generated method stub
		return empDAO.getEmpList();
	}
	

}
