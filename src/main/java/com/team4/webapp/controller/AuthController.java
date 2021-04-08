package com.team4.webapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.services.AuthServiceImpl;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthServiceImpl authService;
	
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	/**
	 * 회원 서비스를 이용하기 위해 필요한 로그인 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/login")
	public String loginPage() {
		return "auth/login";
	}
	
	/**
	 * 회원가입을 하기 위해 필요한 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/register")
	public String registerPage() {
		return "auth/register";
	}
	
	/**
	 * 회원가입 후 회원 정보를 보여주기 위한 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/welcome")
	public String welcomePage() {
		return "auth/welcome";
	}
	/**
	 * 회원이 비밀번호를 찾기위해 필요한 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/forgot-my-pw")
	public String forgotMyPwPage() {
		return "auth/forgot-my-pw";
	}
	
	/**
	 * 회원의 정보(이메일과 이름)이 동일한지 체크하고, 결과를 보내주는 컨트롤러
	 * @param MembersDTO member
	 * @return String
	 */
	@PostMapping("/forgot-my-pw")
	@ResponseBody
	public String findMyPassword(MembersDTO member) {
		String email = member.getMember_email();
		String name = member.getMember_name();
		boolean result = authService.findMyPassword(email, name);
		if(result) {
			return "success";
		} else {
			return "failure";
		}
	}
	/**
	 * 회원이 비밀번호 찾기를 수행 후 올바른 이메일과 비밀번호를
	 * 입력했다면 볼 수 있는 컨트롤러
	 * @return viewName
	 */
	@GetMapping("/forgot-my-pw-result")
	public String forgotMyPwResultPage() {
		return "auth/forgot-my-pw-result";
	}
	

	/**
	 * 회원가입을 수행시에 ajax로 요청이 들어오면 실행되는 컨트롤러
	 * @param MembersDTO member (회원 정보를 담아 가져오기 위해)
	 * @param HttpServletResponse response (쿠키를 저장하기 위해)
	 * @return String
	 */
	@PostMapping("/register")
	@ResponseBody
	public String registerMember(MembersDTO member, HttpServletResponse response) {
		int row = authService.registMember(member);
		if(row == 1) {
			Cookie memeberEmailCookie = new Cookie("member_email", member.getMember_email());
			response.addCookie(memeberEmailCookie);
			return "success";
		} else {
			return "failure";
		}
	}
	/**
	 * 회원가입시에 존재하는 이메일인지 확인하기 위해 사용하는 컨트롤러
	 * @param MembersDTO member
	 * @return String
	 */
	@PostMapping("/existed-email")
	@ResponseBody
	public String isExistedEmail(MembersDTO member) {
		String email = member.getMember_email();
		boolean result = authService.isExistedEmail(email);
		if(result) {
			return "failure";
		} else {
			return "success";
		}
	}
	
	
}
