package com.team4.webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team4.webapp.dao.MembersDAO;
import com.team4.webapp.dao.OrderlistsDAO;
import com.team4.webapp.dao.OrdersDAO;
import com.team4.webapp.dao.ProductsDAO;
import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.MyPageDTO;
import com.team4.webapp.dto.MyPageListDTO;
import com.team4.webapp.dto.OrderlistsDTO;
import com.team4.webapp.dto.OrdersDTO;
import com.team4.webapp.dto.ProductsDTO;

@Service
public class AccountServiceImpl implements IAccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	
	@Autowired
	private OrdersDAO ordersDAO;
	@Autowired
	private OrderlistsDAO orderlistsDAO;
	@Autowired
	private ProductsDAO productsDAO;
	@Autowired
	private MembersDAO membersDAO;
	/**
	 * 서비스 목적
	 * - 회원이 자신의 회원 정보, 주문 리스트를 보기 위해 제공하는 서비스
	 * - 컨트롤러에 MyPageDTO를 전달해 줘야 한다.
	 */
	@Override
	@Deprecated
	public MyPageDTO showMyPageInfo(Long member_id) {
	
		return null;
	}

	/**
	 * 서비스 목적
	 * - 회원이 자신이 주문한 상세 내역 (주문자, 수취인, 상품 리스트(상품, 주문기록))을 보여주기 위한 서비스
	 * - 컨트롤러에 MyPageDTO를 전달해 줘야 한다.
	 */
	@Override
	public List<MyPageListDTO> showMyOrderInfo(Long member_id) {
		List<MyPageListDTO> mypageLists = new ArrayList<>();
		List<OrdersDTO> orders = ordersDAO.selectByMemberId(member_id);
		List<OrderlistsDTO> orderlists = new ArrayList<>();
		for(OrdersDTO order : orders) {
			List<MyPageDTO> mypageList = new ArrayList<MyPageDTO>();
			MyPageListDTO mypageInfoList = new MyPageListDTO();
			mypageInfoList.setOrder_id(order.getOrder_id());
			mypageInfoList.setOrder_date(order.getOrder_date());
			orderlists = orderlistsDAO.selectByOrderId(order.getOrder_id());
			for(OrderlistsDTO orderlist : orderlists) {
				ProductsDTO products = productsDAO.selectByProductId(orderlist.getProduct_id());
				MyPageDTO mypage = new MyPageDTO();
				mypage.setOrderInfo(orderlist);
				mypage.setProductsInfo(products);
				String filePath = "/webapp/image?path="+ mypage.getProduct_image();
				mypage.setProduct_image(filePath);
				mypageList.add(mypage);
				logger.info(mypage.toString());
			}
			mypageInfoList.setMyPageList(mypageList);
			mypageLists.add(mypageInfoList);
		}
		
		return mypageLists;
	}

	/**
	 * 서비스 목적
	 * - 회원이 자신의 정보를 보기 위해 제공하는 서비스
	 * - 컨트롤러에 MembersDTO를 반환해야 한다.
	 */
	@Override
	public List<MyPageDTO> showMyInfo(Long order_id) {
		List<MyPageDTO> orderinfolist = new ArrayList<>();
		List<OrderlistsDTO> orderlists = orderlistsDAO.selectByOrderId(order_id);
		for(OrderlistsDTO orderlist : orderlists) {
			ProductsDTO products = productsDAO.selectByProductId(orderlist.getProduct_id());
			MyPageDTO orderinfo = new MyPageDTO();
			orderinfo.setOrderInfo(orderlist);
			orderinfo.setProductsInfo(products);
			String filePath = "/webapp/image?path="+ orderinfo.getProduct_image();
			orderinfo.setProduct_image(filePath);
			orderinfolist.add(orderinfo);
		}
		return orderinfolist;
	}
	
	@Override
	public OrdersDTO findOrderbyOrderId(Long order_id) {
		OrdersDTO order = ordersDAO.selectByOrderId(order_id);
		String paymentStatus = order.getOrder_payment_status();
		String deliveryStatus = order.getOrder_delivery_status();
		
		if(paymentStatus.equals("PAYMENT_FINISHED")) {
			order.setOrder_payment_status("결제 완료");
		}
		
		if(deliveryStatus.equals("DELIVERY_PENDING")) {
			order.setOrder_delivery_status("배송 준비중");
		}
		return order;
	}
	/**
	 * 서비스 목적
	 * - 회원이 자신의 정보 (비밀번호, 전화번호, 주소)를 바꾸기 위한 서비스
	 * - 컨트롤러에 영향받은 행의 수를 반환해야 한다.
	 */
	@Override
	public int editMyInfo(MembersDTO member) {
		if(!member.getMember_pw().equals("")) {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(member.getMember_pw());
			member.setMember_pw(encodedPassword);
		} else {
			MembersDTO memberInfo =  membersDAO.selectByEmailId(member.getMember_email());
			member.setMember_pw(memberInfo.getMember_pw());
		}
		int row = membersDAO.updateMembers(member);
		
		return row;
	}
	
}
