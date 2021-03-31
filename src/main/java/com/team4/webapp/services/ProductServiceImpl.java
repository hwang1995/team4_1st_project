package com.team4.webapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.team4.webapp.controller.ShopController;
import com.team4.webapp.dao.ProductsDAO;
import com.team4.webapp.dto.ProductsDTO;

@Service
public class ProductServiceImpl implements IProductService {
	
	/**
	 * 서비스 목적
	 * - 모든 사용자들이 웹 사이트의 모든 상품을 보기 위해 제공하는 서비스
	 * - 컨트롤러에게 List<ProductsDTO> 를 전달해야 한다.
	 */
	
	@Autowired
	private ProductsDAO productDAO;
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public List<List<ProductsDTO>> showAllProduct(String order) {
		// 1. - 만약 orderBy = "DESC" 라면?
		// 1.1 - ProductsDTO 리스트에 ProductsDAO.selectProductList() 실행
		// 2. - 만약 orderBy = "HIGH" 라면?
		// 2.1 - ProductsDTO 리스트에 ProductsDAO.selectProdutsListOrderByHighPrice() 실행
		// 3. - 만약 orderBy = "LOW" 라면?
		// 3.1 - ProductsDTO 리스트에 ProductsDAO.selectProductsListOrderByLowPrice() 실행
		// 4. - 받은 List<ProductsDTO> 객체를 Controller로 넘긴다.
		
		List<ProductsDTO> lists;
		
		if(order.equals("desc")) {
			lists = productDAO.selectProductsList();
		}
		else if(order.equals("high")) {
			lists = productDAO.selectProdutsListOrderByHighPrice();
		}else{
			lists = productDAO.selectProductsListOrderByLowPrice();
		}
		for(ProductsDTO product : lists ) {
			String filePath = "/webapp/image?path="+ product.getProduct_image();
			product.setProduct_image(filePath);
		}
		
		List<List<ProductsDTO>> subLists = Lists.partition(lists, 4);
		
		return subLists;
	}

	/**
	 * 서비스 목적
	 * - 모든 사용자들이 카테고리의 상품을 보기 위해 제공하는 서비스
	 * - 컨트롤러에게 List<ProductsDTO> 를 전달해야 한다.
	 */
	@Override
	public List<ProductsDTO> showProductList(String category, String orderBy) {
		// 1. - ProductsDAO에 selectProductListWithCategory(String category, String orderBy)를 실행하여 저장
		// 2. 받은 List<ProductsDAO> 객체를 Controller로 넘긴다.
		return null;
	}
	
	/**
	 * 서비스 목적
	 * - 모든 사용자들이 카테고리의 상품을 보기 위해 제공하는 서비스
	 * - 컨트롤러에게 List<ProductsDTO> 를 전달해야 한다.
	 */
	@Override
	public List<ProductsDTO> showProductList(String category, String subcategory, String orderBy) {
		// 1. - ProductsDAO에 selectProductListWithCategoryAndSubCategory(String category, String subcategory, String orderBy)를 실행하여 저장
		// 2. 받은 List<ProductsDAO> 객체를 Controller로 넘긴다.
		return null;
	}

	/**
	 * 미구현 사항
	 * 서비스 목적
	 * - 관리자가 상품을 추가하기 위해 제공하는 서비스
	 * - 반환 값으로 insert 되었는지 affected rows를 반환
	 */
	@Override
	public int addProduct(ProductsDTO product) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 미구현 사항
	 * 서비스 목적
	 * - 관리자가 상품을 제거하기 위해 제공하는 서비스
	 * - 반환 값으로 drop 되었는지 affected rows를 반환
	 */
	@Override
	public int removeProduct(Long product_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
