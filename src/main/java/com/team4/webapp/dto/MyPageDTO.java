package com.team4.webapp.dto;

import java.util.List;

public class MyPageDTO {
	private MembersDTO memberInfo;
	private List<OrdersDTO> ordersInfo;
	private List<OrderDetailsDTO> orderDetailsInfo;
	
	// Getters & Setters
	public MembersDTO getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MembersDTO memberInfo) {
		this.memberInfo = memberInfo;
	}
	public List<OrdersDTO> getOrdersInfo() {
		return ordersInfo;
	}
	public void setOrdersInfo(List<OrdersDTO> ordersInfo) {
		this.ordersInfo = ordersInfo;
	}
	public List<OrderDetailsDTO> getOrderDetailsInfo() {
		return orderDetailsInfo;
	}
	public void setOrderDetailsInfo(List<OrderDetailsDTO> orderDetailsInfo) {
		this.orderDetailsInfo = orderDetailsInfo;
	}
	
	// For Testing purpose -> DTO의 값을 한번에 보고 싶을 때 사용
	@Override
	public String toString() {
		return "MyPageDTO [memberInfo=" + memberInfo + ", ordersInfo=" + ordersInfo + ", orderDetailsInfo="
				+ orderDetailsInfo + "]";
	}
	
	

}
