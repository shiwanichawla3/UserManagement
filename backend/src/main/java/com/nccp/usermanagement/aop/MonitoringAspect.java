package com.nccp.usermanagement.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

	private static final Log LOG = LogFactory.getLog(MonitoringAspect.class);

	@Around("@annotation(com.nccp.usermanagement.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		LOG.info(joinPoint.getSignature() + " executed in " + executionTime + " ms");
		return proceed;
	}
}
