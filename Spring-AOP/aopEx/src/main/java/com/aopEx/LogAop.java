package com.aopEx;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		//공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "시작"); //메서드 실행
		
		//공통기능
		System.out.println("핵심 기능 전에 실행 할 공통 기능입니다. "+System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed(); //핵심 기능 실행
			return obj;
		} finally {
			//공통기능
			System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. "+System.currentTimeMillis());
			
			System.out.println(signatureStr + "끝");
		}
	}
}
