package com.concretio.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
	
	@AfterThrowing(value = "execution(* com.concretio.service.WeatherService.*(..)) || execution(* com.concretio.controller.WeatherController.*(..))",
			throwing = "error")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		System.out.println("Inside Exception " + joinPoint.getSignature());	
		System.out.println("Exceptio " + error.getLocalizedMessage());
	}
}
