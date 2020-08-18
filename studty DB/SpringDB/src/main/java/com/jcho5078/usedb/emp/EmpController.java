package com.jcho5078.usedb.emp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcho5078.usedb.service.EmpService;
import com.jcho5078.usedb.vo.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	@RequestMapping("empForm")
	public String viewEmp(Model model) {
		
		model.addAttribute("empList", empService.viewEmp());
		
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
}
