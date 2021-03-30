package com.team4.webapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.services.AuthServiceImpl;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthServiceImpl authService;
	
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
	
	@PostMapping("/register")
	@ResponseBody
	public String registerMember(MembersDTO member, HttpServletResponse response) {
		int row = authService.registMember(member);
		if(row == 1) {
			Cookie memeberEmailCookie = new Cookie("member_email", member.getMember_email());
			response.addCookie(memeberEmailCookie);
			return "success";
		} else {
			return "failure";
		}
	}
	
	@PostMapping("/existed-email")
	@ResponseBody
	public String isExistedEmail(MembersDTO member) {
		String email = member.getMember_email();
		boolean result = authService.isExistedEmail(email);
		if(result) {
			return "failure";
		} else {
			return "success";
		}
	}
	
	@PostMapping("/forgot-my-pw")
	@ResponseBody
	public String findMyPassword(MembersDTO member) {
		String email = member.getMember_email();
		String name = member.getMember_name();
		boolean result = authService.findMyPassword(email, name);
		if(result) {
			return "success";
		} else {
			return "failure";
		}
	}

}
