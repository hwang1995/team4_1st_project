package com.team4.webapp.services;

import java.util.List;

import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.MyPageDTO;
import com.team4.webapp.dto.MyPageListDTO;
import com.team4.webapp.dto.OrdersDTO;

public interface IAccountService {
	/**
	 * 회원이 회원의 정보, 주문 기록, 상품 리스트를 보여주기 위해 제공하는 인터페이스
	 * @param Long member_id; 
	 * @return MyPageDTO
	 * MyPageDTO
	 * - MembersDTO memberInfo
	 * - List<OrdersDTO> ordersInfo
	 * - List<OrderDetailsDTO> orderDetailsInfo
	 */
	MyPageDTO showMyPageInfo(Long member_id);
	
	/**
	 * 회원이 자신이 주문한 상세 내역(주문자, 수취인, 상품 리스트(상품, 주문 기록))을 보여주기 위해 제공하는 인터페이스
	 * @param Long member_id
	 * @param Long order_id
	 * @return MyPageDTO (회원 정보, 주문 정보, 상품 디테일의 대한 정보) 포함
	 */
	List<MyPageListDTO> showMyOrderInfo(Long member_id);
	
	/**
	 * 회원의 정보를 보여주기 위해 제공하는 인터페이스
	 * @param Long member_id
	 * @return MembersDTO
	 */
	List<MyPageDTO> showMyInfo(Long member_id);
	
	/**
	 * 회원이 정보를 바꾸기 위해 제공하는 인터페이스
	 * @param MembersDTO member
	 * @return int (영향 받은 행의 수를 받기 위하여)
	 */
	int editMyInfo(MembersDTO member);

	OrdersDTO findOrderbyOrderId(Long order_id);
}
