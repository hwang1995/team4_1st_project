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
//		List<CartsDTO> cartLists = cartsDAO.se
		List<CartsDTO> cartLists = cartsDAO.selectCartListByMemberId(member_id);
		List<CartListDTO> cartInfoLists = new ArrayList<CartListDTO>();
		
		for(CartsDTO cart : cartLists) {
			CartListDTO cartInfoList = new CartListDTO();
			Long product_id = cart.getProduct_id();
			ProductsDTO product = productsDAO.selectByProductId(product_id);
			String filePath = "/webapp/image?path="+ product.getProduct_image();
			product.setProduct_image(filePath);
			cartInfoList.setCartsInfo(cart);
			cartInfoList.setProductInfo(product);
			cartInfoLists.add(cartInfoList);
		}
		
		return cartInfoLists;
	}

	@Override
	public boolean addCart(MembersDTO memberInfo, PreOrdersDTO cart) {
		CartsDTO sendData = new CartsDTO();
		sendData.setMemberInfo(memberInfo);
		sendData.setCartInfo(cart);
		int row = cartsDAO.insertCarts(sendData);
		if(row != 1) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean removeCart(Long cart_id) {
		int rows = cartsDAO.deleteByCartId(cart_id);
		if(rows != 1) {
			return false;
		} 
		return true;
	}
	
	// ?????? - ?????? ????????? ??????.
	@Override
	public List<CheckoutListDTO> showOrderlists(List<PreOrdersDTO> preorder) {
		List<CheckoutListDTO> info = new ArrayList<>();
		for(PreOrdersDTO order : preorder) {
			CheckoutListDTO combinedData = new CheckoutListDTO();
			Long product_id = order.getProduct_id();
			ProductsDTO product = productsDAO.selectByProductId(product_id);
			String filePath = "/webapp/image?path="+ product.getProduct_image();
			product.setProduct_image(filePath);
			combinedData.setProductsInfo(product);
			combinedData.setPreOrdersInfo(order);
			info.add(combinedData);
		}
		
		return info;
	}

	@Override
	public boolean doCheckout(List<CheckoutListDTO> itemLists, CheckoutDTO orderInfo) {
		
		// 1. ????????? ???????????????.
		OrdersDTO order = new OrdersDTO();
		order.setOrderInfo(orderInfo);
		order.setOrderStatus(0, "PAYMENT_FINISHED", "DELIVERY_PENDING");
		int row = ordersDAO.insertOrders(order);
		// 2. ????????? ????????? ??? ???????????? ????????????.
		if(row != 1) {
			return false;
		}
		// 3. ????????? ???????????? ?????? Long order_id; ??? ???????????????.
		Long order_id = order.getOrder_id();
		
		for(CheckoutListDTO item : itemLists) {
			OrderlistsDTO orderlist = new OrderlistsDTO();
			orderlist.setOrder_id(order_id);
			orderlist.setCheckoutInfo(item);
			int rows = orderlistsDAO.insertOrderlists(orderlist);
			if(rows != 1) {
				return false;
			}
		}
		
		

		
		return true;
	}

	@Override
	public List<PreOrdersDTO> getNewCartList(Long member_id) {
		// ?????? ID??? ???????????? ?????? ????????? ????????????.
		List<CartsDTO> cartList = cartsDAO.selectCartListByMemberId(member_id);
		
		// ?????? ?????? ????????? ?????????.
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
		if(rows < 1) {
			return false;
		}
		
		return true;
	}

	
	
	
	
	

}
