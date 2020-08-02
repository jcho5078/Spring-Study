package com.aopEx;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		//bean을 설정한 xml파일이 있는 위치를 지정하여 설정파일을 얻어옴
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCtx.xml");
		
		//설정파일에서 bean을 가져옴
		Cats myCat = ctx.getBean("myCat",Cats.class);
		
		myCat.getCatsInfo();
	}
}
