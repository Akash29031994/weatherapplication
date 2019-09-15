package com.concretio.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Create by Akash Chaturvedi
 * Logs every entry and exit to a method in weather controller and service.
 */

@Aspect
@Component
public class WeatherServiceAspect {
	@Before(value = "execution(* com.concretio.service.WeatherService.*(..)) || execution(* com.concretio.controller.WeatherController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Entering Method " + joinPoint.getSignature());
	}

	@After(value = "execution(* com.concretio.service.WeatherService.*(..)) || execution(* com.concretio.controller.WeatherController.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Exiting Method " + joinPoint.getSignature());
	}
}
