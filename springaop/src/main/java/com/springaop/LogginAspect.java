package com.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogginAspect {
	
//	@Before("execution(public int com.springaop.ProductServiceImpl.multiply(int, int))")
	@Before("execution(* com.springaop.ProductServiceImpl.multiply(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("before methoed called");
	}
	
	@After("execution(* com.springaop.ProductServiceImpl.multiply(..))")
	public void logAfter(JoinPoint joinpoint) {
		System.out.println("after methoed called");
	}

}
