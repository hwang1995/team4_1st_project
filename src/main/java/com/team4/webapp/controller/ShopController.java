package com.team4.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@GetMapping("")
	public String allPage() {
		return "shop/all";
		
	}
	

	
	

}
