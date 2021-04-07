package com.team4.webapp.services;

import java.util.List;

import com.team4.webapp.dto.ProductDetailsDTO;
import com.team4.webapp.dto.ProductsDTO;

public interface IProductService {
	/**
	 * 모든 사용자들이 웹 사이트의 모든 상품을 보기 위해 제공하는 인터페이스
	 * @param String order = "DESC", "HIGH", "LOW"
	 * @return List<List<ProductsDTO>>
	 */
	List<List<ProductsDTO>> showAllProduct(String order);
	
	/**
	 * 모든 사용자들이 해당 카테고리의 상품을 보기 위해 제공하는 인터페이스
	 * @param String subcategory = "Jacket, Coat, Cardigan", "Knit, Shirt, Tee", "Pants, Skirt"
	 * @param String order = "desc", "high", "low"
	 * @return List<ProductsDTO>
	 */
	List<ProductsDTO> showProductByCategory(String subcategory, String order);
	
	/**
	 * 모든 사용자들이 상품의 상세 정보를 보기 위해 제공하는 인터페이스
	 * @param product_id
	 * @return ProductDetailsDTO
	 */
	ProductDetailsDTO showProductDetail(Long product_id);
	
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
