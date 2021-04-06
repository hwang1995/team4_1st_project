package com.team4.webapp.services;

import java.util.List;
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
	
	/**
	 * 서비스 목적
	 * - 모든 사용자들이 모든 상품을 보기 위해 제공하는 서비스
	 * - order = "desc", "high", "low"
	 * - desc : product_id 기준으로 desc 정렬
	 * - high : product_price 기준으로 desc 정렬
	 * - low : product_price 기준으로 asc 정렬
	 */
	@Override
	public List<List<ProductsDTO>> showAllProduct(String order) {
		
		List<ProductsDTO> products;
		
		if(order.equals("desc")) {
			products = productDAO.selectProductsList();
		}
		else if(order.equals("high")) {
			products = productDAO.selectProdutsListOrderByHighPrice();
		}else{
			products = productDAO.selectProductsListOrderByLowPrice();
		}
		//상품의 이미지 경로를 설정하기 위한 for문
		for(ProductsDTO product : products ) {
			String filePath = "/webapp/image?path="+ product.getProduct_image();
			product.setProduct_image(filePath);
		}
		
		//한 row당 4개의 상품을 보여주기 위해 => productLists안에 하나의 리스트 당 상품 4개 담긴 리스트(구아바 라이브러리)
		List<List<ProductsDTO>> productLists = Lists.partition(products, 4);
		
		return productLists;
	}

	/**
	 * 서비스 목적
	 * - 모든 사용자들이 해당 카테고리의 상품을 보기 위해 제공하는 서비스
	 * - subcategory = "Jacket, Coat, Cardigan", "Knit, Shirt, Tee", "Pants, Skirt"
	 * - order = "desc", "high", "low"
	 * - desc : product_id 기준으로 desc 정렬
	 * - high : product_price 기준으로 desc 정렬
	 * - low : product_price 기준으로 asc 정렬 
	 */
	@Override
	public List<ProductsDTO> showProductByCategory(String subCategory, String order) {
		
		 SubCategoriesDTO subCategoriesDTO = subCategoriesDAO.selectBySubCategoryName(subCategory);
		 Long subCategory_id = subCategoriesDTO.getSubcategory_id();
		 List<ProductsDTO> products;
		 
		 if(order.equals("desc")) {
			 products= productDAO.selectBySubCategoryId(subCategory_id);
		 }else if(order.equals("high")) {
			 products=productDAO.selectBySubCategoryIdOrderByHighPrice(subCategory_id);
		 }else {
			 products=productDAO.selectBySubCategoryIdOrderByLowPrice(subCategory_id);
		 }
		
		 //상품의 이미지 경로를 설정하기 위한 for문
		 for(ProductsDTO product : products ) {
				String filePath = "/webapp/image?path="+ product.getProduct_image();
				product.setProduct_image(filePath);
			}
		 
		 return products;
	}
	
	/**
	 * 서비스 목적
	 * - 모든 사용자들이 상품의 상세 정보를 보기 위해 제공하는 서비스
	 */
	@Override
	public ProductDetailsDTO showProductDetail(Long product_id) {
		
		ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
		ProductsDTO productsDTO = new ProductsDTO();
		
		productsDTO = productDAO.selectByProductId(product_id);
		List<ProductImgCarouselDTO> carouselList = productImgsDAO.selectCarouselImgsByProductId(product_id);
		List<ProductImgDetailDTO> detailList = productImgsDAO.selectDetailImgsByProductId(product_id);
		List<ColorsDTO> colorsList = colorsDAO.selectByProductId(product_id);
		List<SizesDTO> sizesList = sizesDAO.selectByProductId(product_id);
		
		//상품의 이미지 경로를 설정하기 위한 for문
		for(ProductImgCarouselDTO carousel : carouselList) {
			carousel.setProduct_img_name("/webapp/image?path=" + carousel.getProduct_img_name());
		}
		for(ProductImgDetailDTO detail : detailList) {
			detail.setProduct_img_name("/webapp/image?path=" + detail.getProduct_img_name());
		}
		
		String filePath = "/webapp/image?path="+ productsDTO.getProduct_image();
		productDetailsDTO.setProduct_image(filePath);
		productDetailsDTO.setProductDetailsInfo(productsDTO,carouselList,detailList,colorsList,sizesList);
		
		return productDetailsDTO;
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
