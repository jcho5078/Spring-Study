package com.web.security.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "manage/updateAllUserForm",method = RequestMethod.GET)
	public String moveUpdateForm(Model model, UserVO vo) {
		
		model.addAttribute("User", vo);
		return "updateForm";
	}
	
	@RequestMapping(value = "manage/updateAllUserForm", method = RequestMethod.POST)
	@ResponseBody//POST만 처리하기에 이 어노테이션 있으면 페이지 이동 안됨.
	public void getUpdateFormAllUser(Model model, @RequestBody UserVO vo) {//@RequestBody로 ajax에서 전송된 json을 객체로 변환
		
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		System.out.println(vo.getPw());
		
		model.addAttribute("User", vo);
		moveUpdateForm(model, vo);
		
		//return vo;//JSON값은 받아오나, 페이지 이동이 안되어 고생중..
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
