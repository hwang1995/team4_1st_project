package com.team4.webapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team4.webapp.dto.CartListDTO;
import com.team4.webapp.dto.CartsDTO;
import com.team4.webapp.dto.CheckoutDTO;
import com.team4.webapp.dto.PreCheckoutDTO;
import com.team4.webapp.dto.ProductDetailsDTO;

@Service
public class OrderServiceImpl implements IOrderService{

	@Override
	public List<CartListDTO> getCartList(Long member_id) {
		// 1 - CartsDAO에서 selectCartListByMemberId를 호출한다.
		// 1.1 - 만약 결과 값이 존재 하지 않는다면 Exception을 throw
		// 1.2 - 만약 결과 값이 존재한다면?
		
		// 2. - for(CartsDTO cart : cartLists) -> CartsDTO의 값을 CartListDTO의 매핑 (새로운 객체를 생성하기 위해)
		// 2.1 - CartsDTO에서 받은 product_id로 ProductDAO에서 selectByProductId를 수행시켜서 값을 저장
		// 2.1.1 - CartListDTO에 name, price를 setter한다.
		// 2.2 - CartsDTO에서 받은 product_id로 ProductImgsDAO에서 selectMainImgByProductId를 수행시켜 값을 저장
		// 2.2.1 - CartListDTO에 image_name을 setter한다.
		// 2.3 - CartListDTO가 완성되었다면 List에 Put 한다.
		
		// 3. List<CartListDTO>를 리턴한다.
		return null;
	}

	@Override
	public int addCart(CartsDTO cart) {
		// 1 - CartsDAO에서 insertCart(CartsDAO cart)를 호출하고 결과 값으로 int rows를 받는다.
		// 2 - row를 리턴한다.
		return 0;
	}

	@Override
	public int removeCart(CartsDTO cart) {
		// 1 - CartsDAO에서 deleteCart(CartsDAO cart)를 호출하고 결과 값으로 int row를 받는다.
		// 2 - row를 리턴한다. 
		return 0;
	}
	
	// 가제 - 수정 가능성 있음.
	@Override
	public PreCheckoutDTO showOrderlists(Long member_id, List<ProductDetailsDTO> products) {
		// member_id를 통하여 MemberDTO 객체를 받아옴.
		
		PreCheckoutDTO preCheckoutDTO = new PreCheckoutDTO();
//		preCheckoutDTO.setMemberInfo();
		preCheckoutDTO.setProducts(products);
		preCheckoutDTO.calcTotalPrice(products);
		return preCheckoutDTO;
	}

	@Override
	public boolean doCheckout(CheckoutDTO checkout) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	

}
