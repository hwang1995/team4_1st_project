package com.team4.webapp.domain;


public class Product {
	private Long id;
	private String productUrl;
	private String productTitle;
	private int productPrice;
	
	public Long getId() {
		return id;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public Product(Long id, String productUrl, String productTitle, int productPrice) {
		this.id = id;
		this.productUrl = productUrl;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
	}

}
