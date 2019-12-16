package com.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionTrackingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.aop.springaop.common.CommonPointCut.methodExecutionTracking()")
	public Object aroundExecutionTracking(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object returnProceed = joinPoint.proceed();
		long endTime = System.currentTimeMillis() - startTime;
		logger.info("@annotation - Time taken by {} is {} milliseconds", joinPoint, endTime);
		return returnProceed;
	}
}
