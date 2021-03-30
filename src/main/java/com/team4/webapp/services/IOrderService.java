package com.team4.webapp.services;

import java.util.List;

import com.team4.webapp.dto.CartListDTO;
import com.team4.webapp.dto.CartsDTO;
import com.team4.webapp.dto.CheckoutDTO;
import com.team4.webapp.dto.PreCheckoutDTO;
import com.team4.webapp.dto.ProductDetailsDTO;

public interface IOrderService {
	
	/**
	 * 회원이 결제를 하기 이전에 회원의 주소, 상품들, 상품의 총 가격을 알려주기 위해 작성한 인터페이스
	 * @param Long member_id
	 * @param List<ProductDetailsDTO> products
	 * @return PreCheckoutDTO (주문전의 데이터를 넘기기 위한 DTO)
	 */
	
	PreCheckoutDTO showOrderlists(Long member_id, List<ProductDetailsDTO> products);
	
	
	/**
	 * 회원이 주문을 진행하기 위해 필요한 인터페이스 
	 * @param CheckoutDTO checkout 
	 * @return true or false
	 */
	boolean doCheckout(CheckoutDTO checkout);
	
	
	/**
	 * 회원이 가지고 있는 장바구니의 상품들을 보여주기 위해 작성한 인터페이스
	 * @param Long member_id
	 * @return List<CartListDTO>
	 */
	List<CartListDTO> getCartList(Long member_id);
	
	/**
	 * 회원이 상품 상세 페이지에서 자신이 주문하고 싶은 상품을 장바구니에 넣기 위한 인터페이스
	 * @param CartsDTO cart
	 * @return int (결과 값으로 쿼리 수행결과를 알기 위해)
	 */
	int addCart(CartsDTO cart);
	
	/**
	 * 회원이 장바구니에서 자신이 추가한 상품을 제거할 수 있는 인터페이스
	 * @param CartsDTO cart
	 * @return int
	 */
	int removeCart(CartsDTO cart);
	
	
}
