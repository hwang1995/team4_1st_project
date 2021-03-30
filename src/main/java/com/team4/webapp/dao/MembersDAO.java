package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team4.webapp.dto.MembersDTO;

@Mapper
public interface MembersDAO {
	public List<MembersDTO> selectMembersList();
	public int insertMembers(MembersDTO membersdto);
	public MembersDTO selectByMemberId(Long member_id);
	public int updateMembers(MembersDTO membersdto);
	public int deleteByMemberId(Long member_id);
	public MembersDTO selectByEmailId(String member_email);
}
