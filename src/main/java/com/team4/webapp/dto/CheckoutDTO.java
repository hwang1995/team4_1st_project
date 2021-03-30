package com.team4.webapp.dto;

import java.util.List;

public class CheckoutDTO {
	private Long member_id;
	private String order_bank;
	private boolean recipient_flag;
	private String recipient_name;
	private String recipient_address;
	private List<ProductDetailsDTO> products;
	
	// Getters & Setters
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getOrder_bank() {
		return order_bank;
	}
	public void setOrder_bank(String order_bank) {
		this.order_bank = order_bank;
	}
	public boolean isRecipient_flag() {
		return recipient_flag;
	}
	public void setRecipient_flag(boolean recipient_flag) {
		this.recipient_flag = recipient_flag;
	}
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	public String getRecipient_address() {
		return recipient_address;
	}
	public void setRecipient_address(String recipient_address) {
		this.recipient_address = recipient_address;
	}
	public List<ProductDetailsDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDetailsDTO> products) {
		this.products = products;
	}
	
	// For Testing purpose -> DTO의 값을 한번에 보고 싶을 때 사용
	@Override
	public String toString() {
		return "CheckoutDTO [member_id=" + member_id + ", order_bank=" + order_bank + ", recipient_flag="
				+ recipient_flag + ", recipient_name=" + recipient_name + ", recipient_address=" + recipient_address
				+ ", products=" + products + "]";
	}
	
	
	
	

}
