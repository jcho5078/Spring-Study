package com.jcho5078.DiUseAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("useFunc")//라이브러리에 있는 클래스는 @Bean을 사용하나, 임의로 만든 클래스는 @Component 사용.
public class UseFunc {
	
	//@Autowired
	private UseVO useVO;
	
	public void UseFunc() {//필드에 @Autowired를 적용시키려면 디폴트 생성자를 명시해야한다. @Resource도 마찬가지.
		
	}
	
	//@Resource(name = "useVO") 해당 컴포넌트의 name으로 접근해 값 받아옴.
	@Autowired
	public void setFunc(UseVO useVO) {
		this.useVO = useVO;
	}
	
	public void getUseVO() {
		System.out.println("Name = " + useVO.getName());
		System.out.println("Num = " + useVO.getNum());
	}
}