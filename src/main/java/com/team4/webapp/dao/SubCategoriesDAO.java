package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.SubCategoriesDTO;

@Mapper
public interface SubCategoriesDAO {
	public List<SubCategoriesDTO> selectSubCategoriesList();
	public int selectBySubCategoryId (Long subCategoryId);
	public int insertSubCategories(SubCategoriesDTO subCategories);
	public int updateSubCategories(SubCategoriesDTO subCategories);
	public int deleteBySubCategoriesId(Long subcategoryId);

}
