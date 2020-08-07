package com.jcho5078.mvc.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserRegistValidation implements Validator{
	   
	   @Override
	   public boolean supports(Class<?> targetClass){
	      return UserRegistRequest.class.isAssignableFrom(targetClass); //메서드에서 인자로 넘어온 객체가 UserRegistRequest인지 검사.
	   }

	   @Override
	   public void validate(Object target, Errors errors){
	      UserRegistRequest regReq = (UserRegistRequest) target;//사용할 클래스
	      if(regReq.getName() == null || regReq.getName().trim().isEmpty()) 
	      //해당 객체의 getter로 불러온 값이 null이나 길이가 0일 경우 에러 등록 실행.
	         errors.rejectValue("name", "required");; //“name”프로퍼티에 에러가 있음을 등록. 자신이 직접 조건을 지정할 때 사용.
	      		
	      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");//위 if문과 같음.

	   }
	}