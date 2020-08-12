package com.jcho5078.DiUseAnnotation;

import org.springframework.stereotype.Component;

@Component("useVO")
public class UseVO {
	
	//사용자가 임의로 만든 클래스는 @Component 사용. Configuration을 사용안하니, 클래스의 기본 내용 등도 클래스 내에 직접 설정하면 그만.
	private String name;
	private int num;
	
	public UseVO() {
		this.name = "냥냥펀치";
		this.num = 1234;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
}
