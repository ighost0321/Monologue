package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTfulService {

	@GetMapping("/api/hello")
	public String hello() {
		return "Hello to you!";
	}
}
