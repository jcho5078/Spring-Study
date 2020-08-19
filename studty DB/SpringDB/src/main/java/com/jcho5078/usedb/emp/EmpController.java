package com.jcho5078.usedb.emp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcho5078.usedb.service.EmpService;
import com.jcho5078.usedb.vo.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	@RequestMapping("empForm")//SqlSessionDaoSupport사용한 select문
	public String viewEmp(Model model) {
		
		model.addAttribute("empList", empService.viewEmp());
		
		return "emp";
	}
	
	@RequestMapping("empForm2")//SqlSession사용한 select문
	public String viewEmp2(EmpVO empVO, Model model) {
		
		model.addAttribute("empList", empService.viewEmp2(empVO));
		
		return "emp";
	}
	
	@RequestMapping("empInsertForm")
	public String empInsertForm(EmpVO empVO, Model model){
		
		return "empInsertForm";
	}
	
	@RequestMapping("empInsert")
	public String insertEmp(EmpVO empVO, Model model){
		empService.insertEmp(empVO);
		return "redirect:/empForm";
	}
	
	@RequestMapping("empDelete")
	public String deleteEmp(EmpVO empVO, Model model){
		empService.deleteEmp(empVO);
		return "redirect:/empForm";
	}
	
	@RequestMapping("empUpdate")
	public String updateEmp(EmpVO empVO, Model model){
		empService.updateEmp(empVO);
		return "redirect:/empForm";
	}
}
