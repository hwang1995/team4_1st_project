package com.team4.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping("/login")
	public String loginPage() {
		return "auth/login";
	}
	
	// redirect 구현 하기
	@GetMapping("/login/result")
	public String loginRedirectPage() {
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "auth/register";
	}
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "auth/welcome";
	}
	
	@GetMapping("/forgot-my-pw-result")
	public String forgotMyPwResultPage() {
		return "auth/forgot-my-pw-result";
	}
	
	@GetMapping("/forgot-my-pw")
	public String forgotMyPwPage() {
		return "auth/forgot-my-pw";
	}

}
