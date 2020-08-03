package com.jcho5078.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UseAnnotationAspect {
	
	@Pointcut("within(com.jcho5078.*)")
	private void profileTarget() {}
	
	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
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
