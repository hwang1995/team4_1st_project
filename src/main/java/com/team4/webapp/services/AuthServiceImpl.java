package com.team4.webapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team4.webapp.dto.MembersDTO;

@Service
public class AuthServiceImpl implements IAuthService {

	/**
	 * 서비스 목적
	 * - 회원이 주문, 장바구니, QnA, 마이 페이지 등을 활용하기 위해 가입하는 서비스
	 * - 컨트롤러에 영향받은 행의 수를 전달해야 한다.
	 */
	@Override
	public int registMember(MembersDTO member) {
		// 1. MembersDAO의 insertMembers(member)를 전달한다.
		// 2. 영향받은 행의 수를 전달한다.
		return 0;
	}

	/**
	 * 서비스 목적
	 * - 회원이 비밀번호를 찾기 위해 사용하는 서비스
	 * - 컨트롤러에 성공했는지, 실패했는지의 boolean 값을 전달해야 한다.
	 */
	@Override
	public boolean findMyPassword(String email, String name) {
		// 1. MembersDAO의 selectByMemberEmail(String email)을 호출한다.
		// 2. 객체에서 이메일을 가져온 후 클라이언트의 이메일과 동등한지 확인
		// 3. 만약 동등하지 않다면 return false;
		// 4. 객체에서 이름을 가져온 후 클라이언트의 이름과 동등한지 확인
		// 5. 만약 동등하지 않다면 return false;
		// 6. 둘다 동등하다면 MembersDTO에 암호화한 비밀번호 "1q2w3e4r"을 넣어준다.
		// 7. MembersDAO에 updateMembers에 멤버 객체를 전달한다.
		
		return false;
	}

	/**
	 * 미구현 사항
	 * - 관리자가 회원을 삭제하기 위해 사용하는 서비스
	 * - 컨트롤러에 영향받은 행의 수를 전달한다.
	 */
	@Override
	public int removeMember(Long member_id) {
		return 0;
	}
	
	/**
	 * 미구현 사항
	 * - 관리자가 회원의 목록을 보기 위해 사용하는 서비스
	 * - 컨트롤러의 회원의 목록을 전달한다.
	 */
	
	@Override
	public List<MembersDTO> showMemberList() {
		return null;
	}

}
