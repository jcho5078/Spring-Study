package com.jcho5078.mvc.validate.annotation;

import org.hibernate.annotations.NotFound;

public class NoValidatorClass {
	
	@NotFound //Validator 클래스를 따로 정의하고 싶지 않다면, 규칙을 정의한 JSR303 Validator을 DI로 설정해 글로번 Validator으로 사용. 
	private String name;

}
