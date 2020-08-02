package com.jcho5078.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {//이 클래스가 proxy라고 할 수 있다.

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println(method+ " 시작");
		
		try {
			
			Object result = joinPoint.proceed();
			return result;
		
		}finally {
			System.out.println(method+" 종료");//메소드 종료시 해당 메소드 종료 알림 
		}
	}
}
