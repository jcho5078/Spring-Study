package com.jcho5078.usedb.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcho5078.usedb.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	@RequestMapping("/empForm")
	public String viewEmp(Model model) {
		
		model.addAttribute("empList", empService.viewEmp());
		
		return "emp";
	}
}
