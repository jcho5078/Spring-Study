package com.my.web.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.web.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired EmpService empService;

	@RequestMapping(value = "/emp.do")
	public String getEmpList(Model model){
		
		model.addAttribute("empList", empService.getEmpList());
		
		return "empList";
	}
	
}
