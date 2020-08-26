package com.web.security.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.security.user.service.UserService;
import com.web.security.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("signUp")
	public String signUpUser(UserVO vo) {
		
		userService.insertUser(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("user/userForm")//개인 정보 조회
	public String moveUserForm(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");//스프링 시큐리티 로그인한 세션에서 로그인 id값 가져옴. 세션 설정은 setAttribute("세션이름").
		
		model.addAttribute("userForm", userService.getUserForm(id));
		
		return "UserForm";
	}
	
	@RequestMapping("manage/viewAllUser")
	public String viewAllUser(Model model, UserVO vo) {
		
		model.addAttribute("viewAllUser", userService.selectUser(vo));
		
		return "viewAllUser";
	}
	
	@RequestMapping("manage/updateAllUser")
	public String updateAllUser(UserVO vo) {
		userService.updateUser(vo);
		return "redirect:/manage/viewAllUser";
	}
	
	@RequestMapping("manage/deleteAllUser")
	public String deleteAllUser(UserVO vo) {
		userService.deleteUser(vo);
		return "redirect:/manage/viewAllUser";
	}
}
