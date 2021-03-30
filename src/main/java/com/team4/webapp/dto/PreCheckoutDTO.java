package com.team4.webapp.dto;

import java.util.List;

public class PreCheckoutDTO {
	private MembersDTO memberInfo;
	private List<ProductDetailsDTO> products;
	private int totalPrice;
	
	// Getter & Setter
	public MembersDTO getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MembersDTO memberInfo) {
		this.memberInfo = memberInfo;
	}
	public List<ProductDetailsDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDetailsDTO> products) {
		this.products = products;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	// For Testing purpose -> DTO의 값을 한번에 보고 싶을 때 사용
	@Override
	public String toString() {
		return "BeforeCheckoutDTO [memberInfo=" + memberInfo + ", products=" + products + ", totalPrice=" + totalPrice
				+ "]";
	}
	
	// 비즈니스 로직 메서드 (계산 통합 메서드)
	public void calcTotalPrice(List<ProductDetailsDTO> products) {
		int totalPrice = 0;
		for(ProductDetailsDTO product : products) {
			totalPrice += product.getProduct_quantity() * product.getProduct_price();
		}
		this.setTotalPrice(totalPrice);
	}
	
	
	
	
	

}
