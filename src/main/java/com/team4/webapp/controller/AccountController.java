package com.team4.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
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
