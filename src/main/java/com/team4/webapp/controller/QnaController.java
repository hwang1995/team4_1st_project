package com.team4.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
public class QnaController {
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@GetMapping("")
	public String qnaPage() {
		return "qna/write-qna";
	}
	
	@GetMapping("/result")
	public String qnaResultPage() {
		return "qna/qna-sended";
	}

}
