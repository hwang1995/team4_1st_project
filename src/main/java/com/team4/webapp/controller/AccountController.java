package com.team4.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.team4.webapp.dto.Pager;
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
	
	@RequestMapping("/mypage")
	public String content(Model model) {
		return "account/mypage";
	}
	
	@GetMapping("/list")
	public String myPage(String pageNo, Model model, Authentication auth, HttpSession session) {
		int intPageNo = 1;
		if(pageNo == null) {
			//세션에서 Pager를 찾고, 있으면 pageNo를 설정
			Pager pager = (Pager) session.getAttribute("pager");
			if(pager != null) {
				intPageNo = pager.getPageNo();
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		
		try {
			//1.이메일로 회원의 정보를 가져옴.
			//2.회원이 주문한 order count를 구하여 페이징을 함.
			//3.페이지 객체를 세션으로 추가하고, 멤버번호를 세팅해줌.
			//4.해당 회원의 주문리스트 정보를 페이징으로 가져옴.
			String email_id = auth.getName();
			MembersDTO memberInfo = authService.findMemberbyEmail(email_id);
			int totalRows = accountService.getTotalOrderRows(memberInfo.getMember_id());
			Pager pager = new Pager(3, 5, totalRows, intPageNo);
			session.setAttribute("pager", pager);
			
			pager.setMember_id(memberInfo.getMember_id());
			List<MyPageListDTO> mypage = accountService.showMyInfo(pager);
			
			model.addAttribute("pager", pager);
			model.addAttribute("member", memberInfo);
			model.addAttribute("mypage", mypage);
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}
		return "account/orderlist";
	}
	
	@GetMapping("/order-info")
	public String orderInfoPage(Long order_id, Authentication auth, Model model) {
		try {
			//1.이메일로 회원의 정보를 가져옴.
			//2.주문번호로 주문 정보를 가져옴.
			//3.주문번호로 주문리스트 정보를 가져옴.
			String email_id = auth.getName();
			MembersDTO memberInfo = authService.findMemberbyEmail(email_id);
			OrdersDTO orderInfo = accountService.findOrderbyOrderId(order_id);
			List<MyPageDTO> orderList = accountService.showMyOrderInfo(order_id);
			
			//1.주문리스트 정보로 총합계를 구함.
			long totalPrice = 0;
			for(MyPageDTO list : orderList) {
				long tempPrice = (long) list.getProduct_quantity() * (long) list.getProduct_price();
				totalPrice += tempPrice;
			}
			
			//1.멤버, 주문, 주문리스트, 총합계를 모델로 넘겨줌.
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
		try {
			//1.이메일로 회원의 정보를 가져옴.
			//2.회원의 정보를 모델로 넘겨줌.
			String email_id = auth.getName();
			MembersDTO memberInfo = authService.findMemberbyEmail(email_id);
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
		//1.회원정보를 넘겨줘서 DB에 update 해줌.
		//2.JSONObject로 JS로 다시 넘겨줌.
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
