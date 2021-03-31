package com.team4.webapp.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home() {
		logger.info(System.getProperty("user.home"));
		
		return "index";
	}
	
	
	@GetMapping("/image")
	public void getImage(HttpServletResponse response, String path) {
		try {
			String home = System.getProperty("user.home");
			String specifyDest = "/images/";
			String filePath = home + specifyDest + path;
			
			response.setContentType("image/jpeg");
			response.setHeader("Content-Disposition", "attachment; filename =" + path);
			InputStream is = new FileInputStream(filePath);
			OutputStream os = response.getOutputStream();
			FileCopyUtils.copy(is, os);
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
