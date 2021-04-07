package com.team4.webapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

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
	
	// 회원의 정보를 가져오기 위해 가져온 AuthServiceImpl
	@Autowired
	private AuthServiceImpl authService;
	
	// 주문의 정보를 가져오기 위해 가져온 OrderSerivceImpl
	@Autowired
	private OrderServiceImpl orderService;
	
	// 로거 설정
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	/**
	 * 장바구니 페이지를 가기위해 작성한 메서드
	 * @param Model model (모델을 추가하여 JSP에서 사용하기 위해)
	 * @param Authentication auth (회원의 이메일을 가져오기 위해)
	 * @return redirect:/
	 */
	@GetMapping("/cart")
	public String cartPage(Model model, Authentication auth) {
		try {
			String email_id = auth.getName();
			long totalPrice = 0;
			
			// 회원 정보와 장바구니 정보를 가져온다.
			MembersDTO memberInfo = authService.findMemberbyEmail(email_id);
			List<CartListDTO> cartLists = orderService.getCartList(memberInfo.getMember_id());
			
			for(CartListDTO cart : cartLists) { 
				totalPrice += cart.calcPrice(cart); 
			}
			
			// 받아온 정보들을 Model로 넣어준다.
			model.addAttribute("cartLists", cartLists);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("memberId", memberInfo.getMember_id());
			
			return "order/cart";
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}

	}
	
	/**
	 * 장바구니에 추가하기 위해 필요한 메서드 (POST /order/cart)
	 * @param PreOrdersDTO data (product_id, product_color, product_size, product_quantity)
	 * @param Authentication auth (회원의 이메일을 가져오기 위해)
	 * @return JSONObject
	 */
	@PostMapping(value = "/cart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String addCart(PreOrdersDTO data, Authentication auth) {
		JSONObject resultObj = new JSONObject();
		try {
			String email_id = auth.getName();
			MembersDTO memberInfo = authService.findMemberbyEmail(email_id);
			
			boolean result = orderService.addCart(memberInfo, data);
			if(result) {
				resultObj.put("status", "success");
			} else {
				resultObj.put("status", "failure");
			}
			logger.info(result + "");
			return resultObj.toString();
			
		} catch(NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			resultObj.put("status", "failure");
			return resultObj.toString();
			
		}
		
	}
	
	/**
	 * 장바구니를 제거하기 위해 필요한 메서드 (POST /order/cart/delete)
	 * @param CartsDTO cart (cart_id, cart_quantity, product_color, product_size, member_id, product_id);
	 * @return JSONObject
	 */
	@PostMapping(value = "/cart/delete", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String removeCart(CartsDTO cart) {
		JSONObject resultObj = new JSONObject();
		
		Long cartId = cart.getCart_id();
		boolean result = orderService.removeCart(cartId);
		if(result) {
			resultObj.put("status", "success");
		} else {
			resultObj.put("status", "failure");
		}
		return resultObj.toString();
	}
	
	/**
	 * 회원이 결제 페이지에 들어가기 위해 필요한 메서드
	 * @param HttpSession session (세션에서 "deleteCart", "orderInfo"를 가져오기 위해)
	 * @param Authentication auth (회원의 이메일을 가져오기 위해)
	 * @param Model model (회원 정보, 주문 리스트, 총 가격을 JSP로 보내기 위해)
	 * @param @RequestParam String isCart (장바구니를 통해서 들어 왔는지 체크하기 위해)
	 * @return viewName
	 */
	@GetMapping("/checkout")
	public String checkOutPage(HttpSession session, Authentication auth, Model model,
							   @RequestParam(name = "isCart", defaultValue="false") String isCart) {
		
		List<PreOrdersDTO> preOrder;
		List<CheckoutListDTO> orderLists;
		long totalPrice =  0;
		
		// Query-string에서 만약 isCart=true라는 값이 들어왔을 시, Session에다가 deleteCart를 추가한다.
		boolean isCartDeleted = Boolean.parseBoolean(isCart);
		if(isCartDeleted) {
			session.setAttribute("deleteCart", isCartDeleted);
		}
		
		// 세션에 preOrder 객체가 존재하는가?
		try {
			preOrder = (List<PreOrdersDTO>) session.getAttribute("orderInfo");
			// preOrder에 담긴 주문 리스트를 가져온다.
			orderLists = orderService.showOrderlists(preOrder);
		} catch(NullPointerException e) {
			logger.warn("올바른 경로로 접속해주세요.");
			return "redirect:/";
		}
		
		
		
		for(CheckoutListDTO order : orderLists) {
			totalPrice += order.calcPrice(order);
		}
		
		try {
			String email_id = auth.getName();
			MembersDTO memberInfo = authService.findMemberbyEmail(email_id);
			
			model.addAttribute("memberInfo", memberInfo);
			model.addAttribute("orderList", orderLists);
			model.addAttribute("totalPrice", totalPrice);
			
			// Checkout 시 session으로 item list를 받아오려고 함.
			session.setAttribute("itemList", orderLists);
			session.removeAttribute("orderInfo");
			
		} catch (NullPointerException e) {
			logger.warn("회원 객체가 존재하지 않습니다.");
			return "redirect:/";
		}
		
		return "order/checkout";
	}
	
	
	/**
	 * 회원이 결제 완료후 보게되는 페이지
	 * @param HttpSession session (구매시간과 총 가격을 가져오기 위해)
	 * @param Model model (구매시간과 총 가격을 JSP로 보내기 위해)
	 * @return "order/checked" or "redirect:/"
	 */
	@GetMapping("/checked")
	public String checkedPage(HttpSession session, Model model) {
		
		try {
			String purchaseTime = (String) session.getAttribute("purchaseTime");
			long totalPrice = (long) session.getAttribute("totalPrice");
			
			model.addAttribute("purchaseTime", purchaseTime);
			model.addAttribute("totalPrice", totalPrice);
			
			session.removeAttribute("purchaseTime");
			session.removeAttribute("totalPrice");
			
			return "order/checked";
		} catch(NullPointerException e) {
			logger.info("주문 기록이 존재하지 않습니다.");
			return "redirect:/";
		}
		
	}
	
	/**
	 * 회원이 결제하기 이전에 API를 호출하여 결제 리스트에 값을 저장하고 세션에 저장하는 메서드
	 * @param PreOrdersDTO data (product_id, product_color, product_size, product_quantity)
	 * @param HttpSession session (주문 정보를 세션에 저장해서 사용하기 위해)
	 * @return JSONObject
	 */
	@PostMapping(value= "/preorder", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String preOrder(PreOrdersDTO data, HttpSession session) {
		JSONObject resultObj = new JSONObject();
		List<PreOrdersDTO> sendData = new ArrayList<>();
		sendData.add(data);
		resultObj.put("status", "success");
		session.setAttribute("orderInfo", sendData);
		
		return resultObj.toString();
		
	}
	
	/**
	 * (장바구니) 회원이 결제하기 이전에 API를 호출하여 결제 리스트에 값을 저장하고 세션에 저장하기 위해 사용하는 메서드
	 * @param MembersDTO member (회원의 ID를 넘겨 받고, 장바구니의 값을 가져오기 위해)
	 * @param HttpSession session (주문정보를 세션에 저장하기 위해)
	 * @return JSONObject
	 */
	@PostMapping(value = "/preorder/cart", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String preOrderThroughCart(MembersDTO member, HttpSession session) {
		JSONObject resultObj = new JSONObject();
		List<PreOrdersDTO> sendData = orderService.getNewCartList(member.getMember_id());
		session.setAttribute("orderInfo", sendData);
		resultObj.put("status", "success");
		
		return resultObj.toString();
		
	}
	
	/**
	 * 결제 하기를 눌렀을 시에 결제를 진행하기 위한 메서드
	 * @param HttpSession session (주문 시간과 총 가격을 저장하기 위해)
	 * @param CheckoutDTO orderInfo (member_id, order_bank, recipient_name, recipient_address, recipient_tel)
	 * @return JSONObject
	 */
	@PostMapping(value= "/checkout", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String checkOut(HttpSession session, CheckoutDTO orderInfo) {
		long totalPrice = 0;
		JSONObject jsonResult = new JSONObject();
		List<CheckoutListDTO> itemList;
		boolean isDeletedCart = false;
		
		// 보내줄 날짜 만들기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDateTime localDateTime = LocalDateTime.now();
		String timeString = localDateTime.format(formatter);
		
		// 장바구니를 통해서 들어왔는지 확인하기 위해 세션 객체를 가져온다.
		try {
			isDeletedCart = (boolean) session.getAttribute("deleteCart");
		} catch(NullPointerException e) {
			logger.info("장바구니를 통해서 오지 않았습니다.");
		}
		

		try {
			// 세션에서 상품 리스트를 가져와서 결과값을 boolean으로 받음.
			itemList = (List<CheckoutListDTO>) session.getAttribute("itemList");
			boolean result = orderService.doCheckout(itemList, orderInfo);
			
			if(result) {
				jsonResult.put("status", "success");
				session.removeAttribute("itemList");
				for(CheckoutListDTO product : itemList) {
					totalPrice += product.calcPrice(product);
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
