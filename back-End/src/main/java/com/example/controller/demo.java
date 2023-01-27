package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class demo {
	@GetMapping("/hello")
	String return1(){
		return "Hello World";
	}
}

