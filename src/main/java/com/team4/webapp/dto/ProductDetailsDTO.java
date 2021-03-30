package com.team4.webapp.dto;

import java.util.List;

public class ProductDetailsDTO {
	private Long product_id;
	private String product_name;
	private int product_price;
	private int product_quantity;
	private String product_content;
	private ProductCategoryDTO product_category;
	private List<ProductImgsDTO> product_imgs_list;
	private List<ProductDescriptionsDTO> product_descriptions_list;
	private List<SizesDTO> product_sizes_list;
	private List<ColorsDTO> product_colors_list;
	
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
	public ProductCategoryDTO getProduct_category() {
		return product_category;
	}
	public void setProduct_category(ProductCategoryDTO product_category) {
		this.product_category = product_category;
	}
	public List<ProductImgsDTO> getProduct_imgs_list() {
		return product_imgs_list;
	}
	public void setProduct_imgs_list(List<ProductImgsDTO> product_imgs_list) {
		this.product_imgs_list = product_imgs_list;
	}
	public List<ProductDescriptionsDTO> getProduct_descriptions_list() {
		return product_descriptions_list;
	}
	public void setProduct_descriptions_list(List<ProductDescriptionsDTO> product_descriptions_list) {
		this.product_descriptions_list = product_descriptions_list;
	}
	public List<SizesDTO> getProduct_sizes_list() {
		return product_sizes_list;
	}
	public void setProduct_sizes_list(List<SizesDTO> product_sizes_list) {
		this.product_sizes_list = product_sizes_list;
	}
	public List<ColorsDTO> getProduct_colors_list() {
		return product_colors_list;
	}
	public void setProduct_colors_list(List<ColorsDTO> product_colors_list) {
		this.product_colors_list = product_colors_list;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	
	@Override
	public String toString() {
		return "ProductDetailsDTO [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_quantity=" + product_quantity + ", product_content=" + product_content
				+ ", product_category=" + product_category + ", product_imgs_list=" + product_imgs_list
				+ ", product_descriptions_list=" + product_descriptions_list + ", product_sizes_list="
				+ product_sizes_list + ", product_colors_list=" + product_colors_list + "]";
	}
	
	
	
	
	
}
