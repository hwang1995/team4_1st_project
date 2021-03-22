package com.team4.webapp.controller;


import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.team4.webapp.domain.Product;

@Controller
public class HomeController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DataSource dataSource;
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	

}
