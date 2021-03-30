package com.team4.webapp.services;

import java.util.List;

import com.team4.webapp.dto.ProductsDTO;

public interface IProductService {
	/**
	 * 모든 사용자들이 웹 사이트의 모든 상품을 보기 위해 제공하는 인터페이스
	 * @param String orderBy = "DESC", "HIGH", "LOW"
	 * @return List<ProductsDTO>
	 */
	List<ProductsDTO> showAllProduct(String orderBy);
	
	/**
	 * 모든 사용자들이 주 카테고리의 상품을 보기 위해 제공하는 인터페이스
	 * @param String category = "outer", "top", "bottom"
	 * @param String orderBy = "DESC", "HIGH", "LOW"
	 * @return List<ProductsDTO>
	 */
	List<ProductsDTO> showProductList(String category, String orderBy);
	
	/**
	 * 모든 사용자들이 주 카테고리 & 부 카테고리의 상품을 보기 위해 제공하는 인터페이스
	 * @param String category = "outer", "top", "bottom"
	 * @param String subcategory = 
	 * 		"jacket", "coat", "jumper",
	 *      "knit", "shirt", "tee",
	 *      "pants", "skirt"
	 * @param String orderBy = "DESC", "HIGH", "LOW"
	 * @return List<ProductsDTO>
	 */
	List<ProductsDTO> showProductList(String category, String subcategory, String orderBy);
	
	/**
	 * 미구현 사항
	 * 상품을 삽입하기 위해 제공하는 인터페이스
	 * @param ProductsDTO product
	 * @return int (영향받은 행의 수를 알기 위해)
	 */
	int addProduct(ProductsDTO product);
	
	/**
	 * 미구현 사항
	 * @param Long product_id
	 * @return int (영향받은 행의 수를 알기 위해)
	 */
	int removeProduct(Long product_id);

}
