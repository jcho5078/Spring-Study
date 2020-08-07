package com.jcho5078.mvc.validate;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reg")
public class RegistController{
   
	@RequestMapping(method = RequestMethod.POST)
	public String regist(@ModelAttribute("userInfo") UserRegistRequest userReq,
			BindingResult bindingResult) {
		
		new UserRegistValidation().validate(userReq, bindingResult);
		if(bindingResult.hasErrors())
	         return "home"; //hasErrors()를 통해 에러가있다는 true를 전달받으면 home.jsp페이지로 이동.
		
		return "home";
	}
}