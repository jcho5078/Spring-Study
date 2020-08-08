package com.jcho5078.mvc.validate;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/valid1")
public class RegistController{
   
	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("userInfo") UserRegistRequest userReq,
			BindingResult bindingResult) {//BindingResult의 객체로 오류검출
		
		new UserRegistValidation().validate(userReq, bindingResult);
		if(bindingResult.hasErrors())
	         return "test"; //hasErrors()를 통해 에러가있다는 true를 전달받으면 test.jsp페이지로 이동.
		
		return "home";
	}
}