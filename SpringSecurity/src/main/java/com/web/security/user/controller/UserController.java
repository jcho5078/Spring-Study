package com.web.security.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		System.out.println();
		
		model.addAttribute("viewAllUser", userService.selectUser(vo));
		
		return "viewAllUser";
	}
	
	@RequestMapping(value = "manage/updateAllUserForm")
	public String getUpdateFormAllUser(Model model, UserVO vo,
			@RequestParam String id, @RequestParam String pw, @RequestParam String name, @RequestParam String hiredate) {//@RequestParam은 html의 name속성으로 값을 받아옴.
		
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setHiredate(hiredate);
		
		model.addAttribute("User", vo);
		
		return "updateForm";//JSON값은 받아오나, 페이지 이동이 안되어 고생중.. ajax가 문제인건가 싶다. RestController의 페이지 이동 공부.
	}
	
	@RequestMapping("manage/updateAllUser")
	public String updateAllUser(UserVO vo) {
		userService.updateUser(vo);
		return "redirect:/manage/viewAllUser";
	}
	
	@RequestMapping("manage/deleteAllUser")
	public String deleteAllUser(UserVO vo) throws Exception{
		userService.deleteUser(vo);
		return "redirect:/manage/viewAllUser";
	}
}
