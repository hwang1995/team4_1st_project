package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.team4.webapp.dto.ProductsDTO;

@Mapper
public interface ProductsDAO {
	public List<ProductsDTO> selectProductsList();
	public ProductsDTO selectByProductId(long product_id);
	public int insertProducts(ProductsDTO products);
	public int updateProducts(ProductsDTO products);
	public int deleteProducts(long product_id);

}
