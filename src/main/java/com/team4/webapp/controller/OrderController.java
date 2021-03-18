package com.team4.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/order")
public class OrderController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@GetMapping("/cart")
	public String cartPage() {
		return "product/product_details";
	}
	
	@GetMapping("/checkout")
	public String checkOutPage() {
		return null;
	}
	
	@GetMapping("/checked")
	public String checkedPage() {
		return null;
	}
	

}
