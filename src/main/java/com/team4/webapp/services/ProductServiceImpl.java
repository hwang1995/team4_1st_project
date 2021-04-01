package com.team4.webapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.team4.webapp.dao.ColorsDAO;
import com.team4.webapp.dao.ProductImgsDAO;
import com.team4.webapp.dao.ProductsDAO;
import com.team4.webapp.dao.SizesDAO;
import com.team4.webapp.dao.SubCategoriesDAO;
import com.team4.webapp.dto.ColorsDTO;
import com.team4.webapp.dto.ProductDetailsDTO;
import com.team4.webapp.dto.ProductImgCarouselDTO;
import com.team4.webapp.dto.ProductImgDetailDTO;
import com.team4.webapp.dto.ProductsDTO;
import com.team4.webapp.dto.SizesDTO;
import com.team4.webapp.dto.SubCategoriesDTO;

@Service
public class ProductServiceImpl implements IProductService {
	
	/**
	 * 서비스 목적
	 * - 모든 사용자들이 웹 사이트의 모든 상품을 보기 위해 제공하는 서비스
	 * - 컨트롤러에게 List<ProductsDTO> 를 전달해야 한다.
	 */
	
	@Autowired
	private ProductsDAO productDAO;
	@Autowired
	private SubCategoriesDAO subCategoriesDAO;
	@Autowired
	private ProductImgsDAO productImgsDAO;
	@Autowired
	private ColorsDAO colorsDAO;
	@Autowired
	private SizesDAO sizesDAO;
	
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
	public List<ProductsDTO> showProductList(String category, String order) {
		// 1. - ProductsDAO에 selectProductListWithCategory(String category, String orderBy)를 실행하여 저장
		// 2. 받은 List<ProductsDAO> 객체를 Controller로 넘긴다.
		
		 logger.info(category);
		 SubCategoriesDTO subCategoriesDTO = subCategoriesDAO.selectBySubCategoryName(category);
		 Long subCategory_id = subCategoriesDTO.getSubcategory_id();
		 List<ProductsDTO> lists;
		 if(order.equals("desc")) {
			 lists= productDAO.selectBySubCategoryId(subCategory_id);
		 }else if(order.equals("high")) {
			 lists=productDAO.selectBySubCategoryIdOrderByHighPrice(subCategory_id);
		 }else {
			 lists=productDAO.selectBySubCategoryIdOrderByLowPrice(subCategory_id);
		 }
		 
		 for(ProductsDTO product : lists ) {
				String filePath = "/webapp/image?path="+ product.getProduct_image();
				product.setProduct_image(filePath);
			}
		 
		 return lists;
	}
	/**
	 * productDetailPage
	 */
	@Override
	public ProductDetailsDTO productDetailPage(Long product_id) {
		
		ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
		ProductsDTO productsDTO = new ProductsDTO();
		productsDTO = productDAO.selectByProductId(product_id);
		List<ProductImgCarouselDTO> carouselLists = productImgsDAO.selectCarouselImgsByProductId(product_id);
		List<ProductImgDetailDTO> detailLists = productImgsDAO.selectDetailImgsByProductId(product_id);
		List<ColorsDTO> colorsLists = colorsDAO.selectByProductId(product_id);
		List<SizesDTO> sizesLists = sizesDAO.selectByProductId(product_id);
		for(ProductImgCarouselDTO carousel : carouselLists) {
			carousel.setProduct_img_name("/webapp/image?path=" + carousel.getProduct_img_name());
		}
		for(ProductImgDetailDTO detail : detailLists) {
			detail.setProduct_img_name("/webapp/image?path=" + detail.getProduct_img_name());
		}
		
		productDetailsDTO.setProduct_id(productsDTO.getProduct_id());
		productDetailsDTO.setProduct_name(productsDTO.getProduct_name());
		productDetailsDTO.setProduct_price(productsDTO.getProduct_price());
		productDetailsDTO.setProduct_content(productsDTO.getProduct_content());
		productDetailsDTO.setProduct_subcontent(productsDTO.getProduct_subcontent());
		String filePath = "/webapp/image?path="+ productsDTO.getProduct_image();
		productDetailsDTO.setProduct_image(filePath);
		productDetailsDTO.setProduct_imgs_carousel_list(carouselLists);
		productDetailsDTO.setProduct_imgs_detail_list(detailLists);
		productDetailsDTO.setProduct_colors_list(colorsLists);
		productDetailsDTO.setProduct_sizes_list(sizesLists);
		
		return productDetailsDTO;
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
