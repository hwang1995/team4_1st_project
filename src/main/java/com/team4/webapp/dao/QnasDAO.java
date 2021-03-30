package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.QnasDTO;

@Mapper
public interface QnasDAO {
	public List<QnasDTO> selectQnasList();
	public int insertQnas(QnasDTO qnasdto);
	public QnasDTO selectByQnaId(Long qna_id);
	public int updateQnas(QnasDTO qnasdto);
	public int deleteByQnaId(Long qna_id);
}
