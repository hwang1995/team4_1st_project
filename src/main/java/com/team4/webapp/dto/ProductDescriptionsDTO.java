package com.team4.webapp.dto;

public class ProductDescriptionsDTO {
	private Long product_description_id;
	private String product_description_content;
	private Long product_id;
	
	// Getters & Setters
	public Long getProduct_description_id() {
		return product_description_id;
	}
	public void setProduct_description_id(Long product_description_id) {
		this.product_description_id = product_description_id;
	}
	public String getProduct_description_content() {
		return product_description_content;
	}
	public void setProduct_description_content(String product_description_content) {
		this.product_description_content = product_description_content;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	
	// For Testing purpose -> DTO의 값을 한번에 보고 싶을 때 사용
	@Override
	public String toString() {
		return "ProductDescriptionsDTO [product_description_id=" + product_description_id
				+ ", product_description_content=" + product_description_content + ", product_id=" + product_id + "]";
	}
	
	
	

}
