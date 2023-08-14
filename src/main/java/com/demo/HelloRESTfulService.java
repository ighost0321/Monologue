package com.demo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class HelloRESTfulService {
	private static final Logger log = (Logger) LoggerFactory.getLogger(HelloRESTfulService.class);

	@GetMapping("/api/hello")
	public String hello() {
		log.info("Hello to you!");
		return "Hello to you!";
	}
}
