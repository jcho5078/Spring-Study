package com.web.security.user.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.security.user.CustomUserDetails;
import com.web.security.user.CustomUserDetailsService;
import com.web.security.user.service.UserService;
import com.web.security.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	//회원가입 페이지 이동
	@RequestMapping("signUpPage")
	public String moveSignUpPage() {
		
		return "signUp";
	}
	
	//회원가입
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public String signUpUser(UserVO vo, 
			@RequestParam String id, @RequestParam String pw, @RequestParam String name) {
		
		String encPassword = userDetailsService.EncodingPw(vo.getPw());//회원가입 하면서 입력된 비밀번호 암호화.
		
		vo.setPw(encPassword);
		
		System.out.println(vo.getId()+","+vo.getPw()+","+vo.getName());
		
		userService.insertUser(vo);
		return "redirect:/login";
	}
	
	//개인정보 조회
	@RequestMapping("user/userForm")
	public String moveUserForm(Model model, Principal principal) {
		
		String id = principal.getName();//스프링 시큐리티로 로그인한 아이디 가져오기.
		
		System.out.println(id);
		
		model.addAttribute("userForm", userService.getUserForm(id));
		
		return "UserForm";
	}
	
	//유저의 개인 정보 수정
	@RequestMapping("user/updateUserForm")
	public String updateUserForm(UserVO vo,
			@RequestParam String pw) {
		
		String encPw = userDetailsService.EncodingPw(pw);
		
		System.out.println(pw);
		System.out.println(encPw);
		
		vo.setPw(encPw);
		
		userService.updatePrivateUser(vo);
		
		return "redirect:/";
	}
	
	//유저의 개인 탈퇴
	@RequestMapping("user/deleteUser")
	public String deletePrivateUser(UserVO vo) throws Exception{
		userService.deleteUser(vo);
		return "delete";
	}
	
	//모든 회원 정보 조회
	@RequestMapping("manage/viewAllUser")
	public String viewAllUser(Model model, UserVO vo) {
		
		model.addAttribute("viewAllUser", userService.selectUser(vo));
		
		return "viewAllUser";
	}
	
	//모든 회원 정보 조회창에서 수정버튼 누르면 해당 회원 정보 가지고 수정 페이지로 이동.
	@RequestMapping(value = "manage/updateAllUserForm")
	public String getUpdateFormAllUser(Model model, UserVO vo,
			@RequestParam String id, @RequestParam String name, @RequestParam String hiredate) {//@RequestParam은 html의 name속성으로 값을 받아옴.
		
		vo.setId(id);
		vo.setName(name);
		vo.setHiredate(hiredate);
		
		model.addAttribute("User", vo);
		
		return "updateForm";
	}
	
	@RequestMapping("manage/updateAllUser")//관리자가 선택한 회원 정보 수정.
	public String updateAllUser(UserVO vo) {
		userService.updateUser(vo);
		return "redirect:/manage/viewAllUser";
	}
	
	@RequestMapping("manage/deleteAllUser")
	public String deleteAllUser(UserVO vo) throws Exception{
		userService.deleteUser(vo);
		return "redirect:/manage/viewAllUser";
	}
	
	//로그인 페이지 이동
		@RequestMapping("login")
		public String moveLoginPage() {
			return "loginForm";
		}
	
	//로그인 실패
	@RequestMapping("login_duplicate")
	public String login_duplicate() {
		System.out.println("login_duplicate!");
		return "login_duplicate";
	}
}
