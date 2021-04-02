package com.team4.webapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.webapp.dto.CartListDTO;
import com.team4.webapp.dto.CartsDTO;
import com.team4.webapp.dto.CheckoutDTO;
import com.team4.webapp.dto.CheckoutListDTO;
import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.PreOrdersDTO;
import com.team4.webapp.dto.ProductsDTO;
import com.team4.webapp.services.AuthServiceImpl;
import com.team4.webapp.services.OrderServiceImpl;
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private AuthServiceImpl authService;
	
	@Autowired
	private OrderServiceImpl orderService;
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	@GetMapping("/cart")
	public String cartPage(Model model, Authentication auth) {
		MembersDTO memberInfo = null;
		List<CartListDTO> cartLists = null;
		int totalPrice = 0;
		try {
			String email_id = auth.getName();
			memberInfo = authService.findMemberbyEmail(email_id);
			cartLists = orderService.getCartList(memberInfo.getMember_id());
			for(CartListDTO cart : cartLists) {
				int tempPrice = cart.getCart_quantity() * cart.getProduct_price();
				totalPrice += tempPrice;
			}
			model.addAttribute("cartLists", cartLists);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("memberId", memberInfo.getMember_id());
			
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}
		return "order/cart";
	}
	
	@PostMapping(value = "/cart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String addCartPage(PreOrdersDTO data, Authentication auth) {
		MembersDTO memberInfo = null;
		JSONObject jsonObj = new JSONObject();
		try {
			String email_id = auth.getName();
			memberInfo = authService.findMemberbyEmail(email_id);
			boolean result = orderService.addCart(memberInfo, data);
			if(result) {
				jsonObj.put("status", "success");
			}else {
				jsonObj.put("status", "failure");
			}
			
		} catch(NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
		}
		
		
		return jsonObj.toString();
		
	}
	
	
	@PostMapping(value = "/cart/delete", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String removeCartPage(CartsDTO cart) {
		JSONObject jsonObj = new JSONObject();
		Long cartId = cart.getCart_id();
		boolean result = orderService.removeCart(cartId);
		if(result) {
			jsonObj.put("status", "success");
			return jsonObj.toString();
		} else {
			jsonObj.put("status", "failure");
			return jsonObj.toString();
		}
		
		
	}
	
	@GetMapping("/checkout")
	public String checkOutPage(HttpSession session, Authentication auth, Model model,
							   @RequestParam(name = "isCart", defaultValue="false") String isCart) {
		
		// Query-string에서 만약 isCart=true라는 값이 들어왔을 시, Session에다가 deleteCart를 추가한다.
		boolean isCartDeleted = Boolean.parseBoolean(isCart);
		if(isCartDeleted) {
			session.setAttribute("deleteCart", isCartDeleted);
		}
		List<PreOrdersDTO> preOrder;
		List<CheckoutListDTO> orderLists;
		long totalPrice =  0;
		try {
			
			preOrder = (List<PreOrdersDTO>) session.getAttribute("orderInfo");
			orderLists = orderService.showOrderlists(preOrder);
			// Testing
			for(CheckoutListDTO order : orderLists) {
				int tempPrice = order.getProduct_price() * order.getProduct_quantity();
				totalPrice += tempPrice;
				
			}
		
		} catch(NullPointerException e) {
			logger.warn("올바른 경로로 접속해주세요.");
			return "redirect:/";
		}
		
		
		MembersDTO memberInfo = null;
		try {
			String email_id = auth.getName();
			memberInfo = authService.findMemberbyEmail(email_id);
			logger.info(memberInfo.toString());
			
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
		}
		
		model.addAttribute("memberInfo", memberInfo);
		model.addAttribute("orderList", orderLists);
		model.addAttribute("totalPrice", totalPrice);
		
		// Checkout 시 session으로 item list를 받아오려고 함.
		session.setAttribute("itemList", orderLists);
		
		session.removeAttribute("orderInfo");
		return "order/checkout";
	}
	
	@GetMapping("/checked")
	public String checkedPage(HttpSession session, Model model) {
		String purchaseTime = null;
		int totalPrice = 0;
		
		try {
			purchaseTime = (String) session.getAttribute("purchaseTime");
			totalPrice = (int) session.getAttribute("totalPrice");
		} catch(NullPointerException e) {
			logger.info("주문 기록이 존재하지 않습니다.");
		}
		
		model.addAttribute("purchaseTime", purchaseTime);
		model.addAttribute("totalPrice", totalPrice);
		
		// 다시 볼거 아니니까 세션 지우기
		
		session.removeAttribute("purchaseTime");
		session.removeAttribute("totalPrice");
		
		return "order/checked";
	}
	
	@PostMapping(value= "/preorder", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String preOrder(PreOrdersDTO data, HttpSession session) {
		JSONObject jsonData = new JSONObject();
		List<PreOrdersDTO> sendData = new ArrayList<>();
		sendData.add(data);
		jsonData.put("status", "success");
		session.setAttribute("orderInfo", sendData);
		
		return jsonData.toString();
		
		
	}
	
	@PostMapping(value = "/preorder/cart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String preOrderThroughCart(MembersDTO member, HttpSession session) {
		JSONObject jsonData = new JSONObject();
		List<PreOrdersDTO> sendData = orderService.getNewCartList(member.getMember_id());
		session.setAttribute("orderInfo", sendData);
		jsonData.put("status", "success");
		
		return jsonData.toString();
		
	}
	@PostMapping(value= "/checkout", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String checkOut(HttpSession session, CheckoutDTO orderInfo) {
		int totalPrice = 0;
		JSONObject jsonResult = new JSONObject();
		List<CheckoutListDTO> itemList;
		boolean isDeletedCart = false;
		// 장바구니를 통해서 들어왔는지 확인하기 위해 세션 객체를 가져온다.
		try {
			isDeletedCart = (boolean) session.getAttribute("deleteCart");
		} catch(NullPointerException e) {
			logger.info("장바구니를 통해서 오지 않았습니다.");
		}
		
		// 보내줄 날짜 만들기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDateTime localDateTime = LocalDateTime.now();
		String timeString = localDateTime.format(formatter);
		try {
			itemList = (List<CheckoutListDTO>) session.getAttribute("itemList");
			boolean result = orderService.doCheckout(itemList, orderInfo);
			
			if(result) {
				// 성공 JSON 리턴
				jsonResult.put("status", "success");
				// 성공했으니 itemList 세션 지우기
				session.removeAttribute("itemList");
				// itemList에 남겨져있는 product 정보로 총 합 구하기
				for(CheckoutListDTO product : itemList) {
					int tempPrice = product.getProduct_price() * product.getProduct_quantity();
					totalPrice += tempPrice;
				}
				
				// 회원이 장바구니를 통해 주문을 하고, 성공했을시에 장바구니를 지워준다.
				if(isDeletedCart) {
					session.removeAttribute("deleteCart");
					boolean deleteResult = orderService.removeCarts(orderInfo.getMember_id());
					if(!deleteResult) {
						jsonResult.put("status", "failure");
						return jsonResult.toString();
					}
				}
			
				session.setAttribute("purchaseTime", timeString);
				session.setAttribute("totalPrice", totalPrice);
				return jsonResult.toString();
			} else {
				jsonResult.put("status", "failure");
				return jsonResult.toString();
			}
			
		} catch(NullPointerException e) {
			logger.warn("올바른 경로로 접속해주세요.");
			jsonResult.put("status", "failure");
			return jsonResult.toString();
		}

		
		
	}
	

}
