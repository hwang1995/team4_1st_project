package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.ColorsDTO;

@Mapper
public interface ColorsDAO {
	public List<ColorsDTO> selectColorList();
	public ColorsDTO selectByColorId(long color_id);
	public int insertColor(ColorsDTO colors);
	public int updateColor(ColorsDTO colors);
	public int deleteColor(long color_id);
}
