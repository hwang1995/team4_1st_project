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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * 홈 화면을 보여주기 위해 필요한 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	/**
	 * 로컬 이미지를 가져오기 위해 필요한 컨트롤러
	 * @param HttpServletResponse response 
	 * (Response Header를 조작하고, payload == body 에 데이터를 담아 전달하기 위해)
	 * @param String path (경로를 가져오기 위해)
	 */
	@GetMapping("/image")
	public void getImage(HttpServletResponse response, String path) {
		try {
			// 홈 디렉토리의 이미지를 가져오는 것으로 설정
			String home = System.getProperty("user.home");
			String specifyDest = "/images/";
			String filePath = home + specifyDest + path;
			
			/**
			 * 모든 이미지는 jpeg이므로, response type과 header를 설정하며
			 * Content-Disposition으로 이 파일이 attachment (첨부파일) 인지 확인하기 위해
			 * 필요하다. 이러한 정보를 response header에 삽입한다.
			 */
			response.setContentType("image/jpeg");
			response.setHeader("Content-Disposition", "attachment; filename =" + path);
			
			/**
			 * 파일 경로의 이미지를 가져와서 프로그램에 Input 후
			 * 바로 Output 하여 payload에 byte[] 를 삽입한다.
			 * 모든 작업이 끝난 후 flush, close한다.
			 */
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
