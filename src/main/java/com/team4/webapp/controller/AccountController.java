package com.team4.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/mypage")
	public String myPage() {
		return "account/mypage";
	}
	
	@GetMapping("/order-info")
	public String orderInfoPage() {
		return "account/order-info";
	}
	
	@GetMapping("/edit-info")
	public String editInfoPage() {
		return "account/edit-my-info";
	}

}
