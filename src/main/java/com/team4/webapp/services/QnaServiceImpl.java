package com.team4.webapp.services;

import org.springframework.stereotype.Service;

import com.team4.webapp.dto.QnasDTO;

@Service
public class QnaServiceImpl implements IQnaService {
	/**
	 * 서비스 목적
	 * - 회원이 상품, 배송, 교환, 기타 문의에 대하여
	 * - 관리자에게 남길 수 있도록 제공하는 서비스
	 */
	@Override
	public int writeQna(Long member_id, QnasDTO qna) {
		/**
		 * 1. QnA 테이블을 넘기기 이전에 qna 객체에
		 * content = ""
		 * member_id = Long member_id로 설정
		 */
		
		// 2. QnasDAO의 insertQnas(QnasDTo qna)를 전달하고 int 값을 반환
		// 3. 만약 반환 받은 값이 1이 아니라면? Exception throw
		// 4. 만약 성공했다면 row를 전달한다.
		
		return 0;
	}

}
