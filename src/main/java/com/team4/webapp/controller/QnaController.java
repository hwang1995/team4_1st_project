package com.team4.webapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.webapp.dto.QnasDTO;
import com.team4.webapp.services.QnaServiceImpl;

@Controller
@RequestMapping("/qna")
public class QnaController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaServiceImpl qnaService;
	
	@GetMapping("")
	public String qnaPage() {
		return "qna/write-qna";
	}
	
	@GetMapping("/result")
	public String qnaResultPage() {
		return "qna/qna-sended";
	}
	
	@PostMapping("/write")
	@ResponseBody
	public String writeQnaPage(QnasDTO qna, Authentication auth, HttpServletResponse response) {
		String member_email = auth.getName();
		int row = qnaService.writeQna(member_email, qna);
		if(row == 1) {
			Cookie memberEmailCookie = new Cookie("member_email", member_email);
			response.addCookie(memberEmailCookie);
			return "success";
		} else {
			return "failure";
		}
	}
}
		

