package com.team4.webapp.services;


import com.team4.webapp.dto.QnasDTO;

public interface IQnaService {
	/**
	 * 회원이 상품, 배송, 교환, 기타 문의에 대해 관리자에게 남길 수 있도록 제공하는 인터페이스
	 * @param Long member_id
	 * @param QnasDTO qna
	 * @return int (insert가 성공적으로 되었는가?)
	 */
	int writeQna(Long member_id, QnasDTO qna);
}
