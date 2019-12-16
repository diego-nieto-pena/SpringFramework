package com.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonJoinPointAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("com.aop.springaop.common.CommonPointCut.dataLayerExecution()")
	public void beforeDataLayer(JoinPoint joinPoint) {
		logger.info("Common Data JointPoint at: {}", joinPoint);
	}
	
	@After("com.aop.springaop.common.CommonPointCut.businessLayerExecution()")
	public void afterBusinessLayer(JoinPoint joinPoint) {
		logger.info("Common Business JointPoint at: {}", joinPoint);
	}
	
	@After("com.aop.springaop.common.CommonPointCut.allLayerExecution()")
	public void allLayerExecution(JoinPoint joinPoint) {
		logger.info("All layer execution {}", joinPoint);
	}
	
	@After("com.aop.springaop.common.CommonPointCut.beanNameContainingao()")
	public void allBeanNameExecution(JoinPoint joinPoint) {
		logger.info("Bean name execution {}", joinPoint);
	}
	
	@After("com.aop.springaop.common.CommonPointCut.dataLayerExecutionWithin()")
	public void allWithinPackageExecution(JoinPoint joinPoint) {
		logger.info("within package execution {}", joinPoint);
	}
}
