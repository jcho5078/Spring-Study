package com.jcho5078.DI;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class Component {//Component 애노테이션에 이름을 지정 안하면 해당 빈이름은 첫글자만 소문자로한 그대로. 여기선comPonent라는 이름의 빈이 생성됨
	
	@Autowired//Component애노테이션을 사용하면 필드나 메소드에 자동설정을 해야함.
	private String str;
}
