package com.team4.webapp.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.MyPageDTO;
import com.team4.webapp.dto.MyPageListDTO;
import com.team4.webapp.dto.OrdersDTO;
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
	public String orderInfoPage(Long order_id, Authentication auth, Model model) {
		MembersDTO memberInfo = null;
		OrdersDTO orderInfo = null;
		List<MyPageDTO> orderList = null;
		try {
			String email_id = auth.getName();
			memberInfo = authService.findMemberbyEmail(email_id);
			orderInfo = accountService.findOrderbyOrderId(order_id);
			orderList = accountService.showMyInfo(order_id);
			
			int totalPrice = 0;
			for(MyPageDTO list : orderList) {
				int tempPrice = list.getProduct_quantity() * list.getProduct_price();
				totalPrice += tempPrice;
			}
			
			model.addAttribute("member", memberInfo);
			model.addAttribute("order", orderInfo);
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}
		return "account/order-info";
	}
	
	@GetMapping("/edit-info")
	public String editInfoPage(Authentication auth, Model model) {
		MembersDTO memberInfo = null;
		try {
			String email_id = auth.getName();
			memberInfo = authService.findMemberbyEmail(email_id);
			model.addAttribute("member", memberInfo);
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}
		return "account/edit-my-info";
	}
	
	@PostMapping(value = "/send-edit-info", produces ="application/json; charset=UTF-8")
	@ResponseBody
	public String sendEditInfo(MembersDTO member) {
		int row = accountService.editMyInfo(member);
		JSONObject jsonObj = new JSONObject();
		if(row == 1) {
			jsonObj.put("status", "success");
			return jsonObj.toString();
		} else {
			jsonObj.put("status", "failure");
			return jsonObj.toString();
		}
	}
}
