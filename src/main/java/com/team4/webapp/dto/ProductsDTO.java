package com.team4.webapp.dto;

public class ProductsDTO {
	private Long product_id;
	private String product_name;
	private int product_price;
	private String product_content;
	private Long subcategory_id;
	
	// Getters & Setters
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public Long getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(Long subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	
	@Override
	public String toString() {
		return "ProductsDTO [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_content=" + product_content + ", subcategory_id=" + subcategory_id + "]";
	}
	
	

}
