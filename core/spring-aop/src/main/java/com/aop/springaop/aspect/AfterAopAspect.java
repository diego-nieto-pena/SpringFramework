package com.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After("execution(* com.aop.springaop.business.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("After execution of: {}", joinPoint);
	}
	
	@AfterReturning(value="execution(* com.aop.springaop.business.*.*(..))", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} Returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(value="execution(* com.aop.springaop.business.*.*(..))", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		logger.info("{} thrown exception {}", joinPoint, exception);
	}
}
