package com.zeljko.instructors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	// inject via application.properties
	//@Value("${welcome.message:test}")


	@RequestMapping("/")
	public String welcome() {
		//model.put("message", this.message);
		return "welcome";
	}

}