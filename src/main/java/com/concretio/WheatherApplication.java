package com.concretio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WheatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WheatherApplication.class, args);
	}
}
