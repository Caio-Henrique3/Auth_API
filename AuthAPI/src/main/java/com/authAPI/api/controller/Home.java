package com.authAPI.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/home")
	public String home() {
		return "Hello user!";
	}
	
}
