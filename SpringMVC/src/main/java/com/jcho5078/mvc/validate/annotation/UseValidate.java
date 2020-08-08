package com.jcho5078.mvc.validate.annotation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/valid2")
public class UseValidate {
	
	@RequestMapping(method = RequestMethod.POST)//@Validated는 @Valid와 비슷함. 추가로 여러 필드를 그룹으로 지정할 수 있다는 점이 있다.
	public String validateReq(@Valid @ModelAttribute("userReq") UserRegReq userReq, Errors errors) {
		//@ModelAttribute 어노테이션에 지정한 이름을 통해 form태그에서는 해당 이름으로 값에 접근 가능하다.
		
		if(errors.hasErrors()) {
			return "test";
		}
		
		return "home";
	}
	
	@InitBinder  //InitBinder 어노테이션을 통해 지정한 메소드를 필연적으로 검사하게 하며, 해당 컨트롤러의 메서드 실행시 데이터를 자동으로 바인딩해줌.
	public void InitBind(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(new UserRegValidation()); //WebDataBinder의 객체의 setValidator()메서드를 통해 정의해둔 검증클래스를 지정함.
	}
}
