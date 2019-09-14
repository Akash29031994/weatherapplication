package com.concretio.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WeatherServiceAspect {
	@Before(value = "execution(* com.concretio.service.WeatherService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Entering Method " + joinPoint.toLongString());
	}

	@After(value = "execution(* com.concretio.service.WeatherService.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Exiting Method " + joinPoint.toLongString());
	}
}
