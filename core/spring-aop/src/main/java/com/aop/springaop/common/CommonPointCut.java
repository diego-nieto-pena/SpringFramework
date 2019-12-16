package com.aop.springaop.common;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {

	@Pointcut("execution(* com.aop.springaop.dao.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("execution(* com.aop.springaop.business.*.*(..))")
	public void businessLayerExecution() {}
	
	@Pointcut("com.aop.springaop.common.CommonPointCut.dataLayerExecution()"
			+ "&& com.aop.springaop.common.CommonPointCut.businessLayerExecution()")
	public void allLayerExecution() {}
	
	@Pointcut("bean(*dao*)")
	public void beanNameContainingao(){}
	
	@Pointcut("within(com.aop.springaop.data..*)")
	public void dataLayerExecutionWithin(){}
	
	@Pointcut("@annotation(com.aop.springaop.annotation.TrackTime)")
	public void methodExecutionTracking() {}
}