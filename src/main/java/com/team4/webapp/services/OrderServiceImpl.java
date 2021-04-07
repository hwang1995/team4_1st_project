package com.team4.webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.webapp.dao.CartsDAO;
import com.team4.webapp.dao.OrderlistsDAO;
import com.team4.webapp.dao.OrdersDAO;
import com.team4.webapp.dao.ProductsDAO;
import com.team4.webapp.dto.CartListDTO;
import com.team4.webapp.dto.CartsDTO;
import com.team4.webapp.dto.CheckoutDTO;
import com.team4.webapp.dto.CheckoutListDTO;
import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.OrderlistsDTO;
import com.team4.webapp.dto.OrdersDTO;
import com.team4.webapp.dto.PreOrdersDTO;
import com.team4.webapp.dto.ProductsDTO;

@Service
public class OrderServiceImpl implements IOrderService{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private ProductsDAO productsDAO;
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private OrderlistsDAO orderlistsDAO;
	
	@Autowired
	private CartsDAO cartsDAO;

	@Override
	public List<CartListDTO> getCartList(Long member_id) {
		// 장바구니와 장바구니의 리스트 (상품과 장바구니를 합친 것)을 만들기 위함.
		List<CartsDTO> cartLists = cartsDAO.selectCartListByMemberId(member_id);
		List<CartListDTO> cartInfoLists = new ArrayList<CartListDTO>();
		
		// 장바구니 리스트를 만들기 위한 로직
		for(CartsDTO cart : cartLists) {
			CartListDTO cartInfoList = new CartListDTO();
			
			Long product_id = cart.getProduct_id();
			ProductsDTO product = productsDAO.selectByProductId(product_id);
			
			product.setImagePath();
			
			cartInfoList.setCartsInfo(cart);
			cartInfoList.setProductInfo(product);
			
			cartInfoLists.add(cartInfoList);
		}
		
		return cartInfoLists;
	}

	@Override
	public boolean addCart(MembersDTO memberInfo, PreOrdersDTO cart) {
		// 장바구니 DTO에 회원 정보와 장바구니 정보를 넣어준다.
		CartsDTO sendData = new CartsDTO();
		
		sendData.setMemberInfo(memberInfo);
		sendData.setCartInfo(cart);
		
		int row = cartsDAO.insertCarts(sendData);
		boolean result = isTransactionSuccess(row);
		
		return result;
	}

	/**
	 * 장바구니 ID로 
	 */
	@Override
	public boolean removeCart(Long cart_id) {
		int rows = cartsDAO.deleteByCartId(cart_id);
		boolean result = isTransactionSuccess(rows);
		
		return result;
	}
	
	@Override
	public List<CheckoutListDTO> showOrderlists(List<PreOrdersDTO> preOrder) {
		// 주문리스트의 정보를 보여주기 위해 존재.
		List<CheckoutListDTO> checkoutInfo = new ArrayList<>();
		
		// 주문 리스트를 생성하는 로직
		for(PreOrdersDTO order : preOrder) {
			CheckoutListDTO combinedData = new CheckoutListDTO();
			Long product_id = order.getProduct_id();
			
			ProductsDTO product = productsDAO.selectByProductId(product_id);
			product.setImagePath();
			
			combinedData.setProductsInfo(product);
			combinedData.setPreOrdersInfo(order);
			checkoutInfo.add(combinedData);
		}
		
		return checkoutInfo;
	}

	@Override
	public boolean doCheckout(List<CheckoutListDTO> itemLists, CheckoutDTO orderInfo) {
		
		// 1. 주문을 생성합시다.
		OrdersDTO order = new OrdersDTO();
		order.setOrderInfo(orderInfo);
		order.setOrderStatus(0, "PAYMENT_FINISHED", "DELIVERY_PENDING");
		int row = ordersDAO.insertOrders(order);
		// 2. 주문이 생성이 잘 되었는지 체크한다.
		boolean result = isTransactionSuccess(row);
		
		// 3. 주문을 생성하고 나온 Long order_id; 를 저장합시다.
		Long order_id = order.getOrder_id();
		
		for(CheckoutListDTO item : itemLists) {
			OrderlistsDTO orderlist = new OrderlistsDTO();
			orderlist.setOrder_id(order_id);
			orderlist.setCheckoutInfo(item);
			int rows = orderlistsDAO.insertOrderlists(orderlist);
			result = isTransactionSuccess(rows);
		}
		
		return result;
	}

	@Override
	public List<PreOrdersDTO> getNewCartList(Long member_id) {
		// 멤버 ID를 이용하여 카트 정보를 가져온다.
		List<CartsDTO> cartList = cartsDAO.selectCartListByMemberId(member_id);
		
		// 값을 보낼 공간을 만든다.
		List<PreOrdersDTO> modifiedList = new ArrayList<PreOrdersDTO>();
		for(CartsDTO cart : cartList) {
			PreOrdersDTO preOrder = new PreOrdersDTO();
			preOrder.setCartInfo(cart);
			modifiedList.add(preOrder);
		}
		
		return modifiedList;
	}

	
	@Override
	public boolean removeCarts(Long member_id) {
		int rows = cartsDAO.deleteByMemberId(member_id);
		boolean result = isTransactionSuccess(rows);
		
		return result;
	}

	public boolean isTransactionSuccess(int rows) {
		boolean result = true;
		
		if(rows != 1) {
			result = false;
		}
		
		return result;
	}
	
	
	
	
	

}
