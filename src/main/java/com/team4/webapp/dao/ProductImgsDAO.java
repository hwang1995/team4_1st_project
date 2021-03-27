package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.ProductImgsDTO;

@Mapper
public interface ProductImgsDAO {
	public List<ProductImgsDTO> selectProductImgList();
	public ProductImgsDTO selectProductImgId(Long product_img_id);
	public int insertProductImg(ProductImgsDTO productImg);
	public int updateProductImg(ProductImgsDTO productImg);
	public int deleteByProductImgId(Long product_img_id);

}
