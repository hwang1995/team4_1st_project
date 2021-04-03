package com.team4.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team4.webapp.dto.CartListDTO;
import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.MyPageDTO;
import com.team4.webapp.dto.MyPageListDTO;
import com.team4.webapp.services.AccountServiceImpl;
import com.team4.webapp.services.AuthServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AuthServiceImpl authService;
	@Autowired
	private AccountServiceImpl accountService;
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/mypage")
	public String myPage(Model model, Authentication auth) {
		MembersDTO memberInfo = null;
		List<MyPageDTO> orderLists = null;
		List<MyPageListDTO> mypage = null;
		try {
			String email_id = auth.getName();
			memberInfo = authService.findMemberbyEmail(email_id);
			mypage = accountService.showMyOrderInfo(memberInfo.getMember_id());

			model.addAttribute("member", memberInfo);
			model.addAttribute("mypage", mypage);
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}
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
