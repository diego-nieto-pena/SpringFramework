package com.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Pointcut + Advice = Aspect
@Aspect
@Configuration
public class BeforeAopAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//execution(* PACKAGE.*.*(..))
	// Pointcut - The expression used to define where to intercept
	@Before("execution(* com.aop.springaop.business.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice - The logic do it 
		logger.info("Validate if the user is allowed to execute the method");
		logger.info("Allowed execution for: {}", joinPoint);
		// JoinPoint - The specific execution instance (specific intercepted method)
	}
}
