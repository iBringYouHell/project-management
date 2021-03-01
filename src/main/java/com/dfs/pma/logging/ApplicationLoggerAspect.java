package com.dfs.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.dfs.pma.controllers..*)")
	public void definePointcuts() {
		// empty method
	}
	
	@After("definePointcuts()")
	public void log(JoinPoint jp) {
		log.debug("\n \n");
		log.debug(" ------------------ ",jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		;
	}
}
