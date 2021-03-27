package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.CategoriesDTO;
import com.team4.webapp.dto.ProductImgsDTO;

@Mapper
public interface ProductImgsDAO {
	public List<ProductImgsDTO> selectProductImgList();
	public ProductImgsDTO selectProductImgId(long product_img_id);
	public int insertProductImg(ProductImgsDTO productImg);
	public int updateProductImg(ProductImgsDTO productImg);
	public int deleteProductImg(long product_img_id);

}
