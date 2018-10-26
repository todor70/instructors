package com.zeljko.instructors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "login";
	}

	@GetMapping("/access_denied")
	public String showAccessDenied() {
		
		return "access_denied";
		
	}
	
}









