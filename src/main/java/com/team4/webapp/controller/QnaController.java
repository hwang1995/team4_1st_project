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
	/**
	 * Q&A 작성 페이지로 이동하기 위한 컨트롤러
	 * @return viewName
	 */
	@GetMapping("")
	public String qnaPage() {
		return "qna/write-qna";
	}
	
	/**
	 * Q&A 작성 후 결과 값을 보여주기 위한 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/result")
	public String qnaResultPage() {
		return "qna/qna-sended";
	}
	/**
	 * 회원이 Q&A를 작성하기 버튼을 누를 시에 ajax 통신을 위한 컨트롤러이며,
	 * 회원의 category, title, content를 넣어 전달해준다.
	 * @param QnasDTO qna (정보를 받기 위해)
	 * @param Authentication auth (회원 정보를 가져오기 위해)
	 * @param HttpServletResponse response (Cookie를 넣기 위해)
	 * @return String
	 */
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
		

