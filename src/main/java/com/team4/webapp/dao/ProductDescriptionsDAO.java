package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.ProductDescriptionsDTO;

@Mapper
public interface ProductDescriptionsDAO {
	public List<ProductDescriptionsDTO> selectProductDescriptionsList();
	public int selectByProductDescriptionsId(Long produtDescriptionId);
	public int insertProductDescriptions(ProductDescriptionsDTO productDescriptions);
	public int updateProductDescriptions(ProductDescriptionsDTO productDescriptions);
	public int deleteByProductDescriptionsId(Long productDescriptionId);
}
