package com.team4.webapp.services;

import org.springframework.stereotype.Service;

import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.MyPageDTO;

@Service
public class AccountServiceImpl implements IAccountService {
	/**
	 * 서비스 목적
	 * - 회원이 자신의 회원 정보, 주문 리스트를 보기 위해 제공하는 서비스
	 * - 컨트롤러에 MyPageDTO를 전달해 줘야 한다.
	 */
	@Override
	public MyPageDTO showMyPageInfo(Long member_id) {
		// 1. member_id로 MemberDAO에서 MemberDTO의 값을 저장한다.
		// 2. member_id를 통해 내림차순으로 정렬된 List<OrderDTO>를 가져옴
		// 3. OrderDetailsDTO 객체 리스트를 저장할 공간을 만듬
		// 4. OrderDetails를 만들기 위해 List<OrderDTO>에 저장된 값을 looping
		// 4.1 - for(OrderDTO order : orders)
		// 4.2 - OrderlistDTO의 리스트를 가져온다. => OrderlistDAO.selectByOrderId();
		// 4.2.1 - for(OrderlistDTO orderlist : orderlists)
		// 4.2.2 - OrderDetailsDTO의 객체를 생성한다. (orderDetails 라는 이름으로)
		// 4.2.3 - orderDetails에 orderlist를 세팅한다. orderDetails.setOrderlist(orderlist)
		// 4.2.4 - Product를 받아온다. Orderlist의 product_id로
		// 4.2.5 - orderDetails에 orderDetail을 넣어준다.
		// 5. - MyPageDTO에 MemberDTO, List<OrderDTO>, List<OrderDetails> 저장
		// 6. 컨트롤러에 MyPageDTO를 전달한다.
		
		return null;
	}

	/**
	 * 서비스 목적
	 * - 회원이 자신이 주문한 상세 내역 (주문자, 수취인, 상품 리스트(상품, 주문기록))을 보여주기 위한 서비스
	 * - 컨트롤러에 MyPageDTO를 전달해 줘야 한다.
	 */
	@Override
	public MyPageDTO showMyOrderInfo(Long member_id, Long order_id) {
		// 1. - MyPageDTO에 객체를 담을 공간을 생성한다. (MyPageDTO orderInfoDat = new MyPageDTO())
		// 2. - member_id를 통해 MemberDTO 객체를 가져온다.
		// 3. - orderInfoData에 memberDTO를 저장한다.
		// 4. - OrdersDTO를 가져오기 위해 OrderDAO에서 selectByOrderId(order_id)를 실행하고 값을 전달받는다.
		// 5. - orderInfoData에 ordersDTO를 저장한다.
		// 6. - OrderlistDTO를 담을 리스트 객체를 생성하고 받아온다.
		// 7. - OrderDetailsDTO를 저장하기 위한 리스트 객체를 생성한다.
		// 8. - OrderDetails를 만들기 위해 Orderlist를 Looping한다.
		// 8.1 - for(OrderlistsDTO orderlist : orderlists)
		// 8.1.1 - OrderDetails 객체를 생성한다.
		// 8.1.2 - OrderDetails 객체에 orderlist를 넣어준다.
		// 8.1.3 - Products를 가져오기 위해 orderlist에 있는 product_id로 조회한다.
		// 8.1.4 - OrderDetails 객체에 product를 넣어준다.
		// 8.1.5 - 다 완성된 OrderDetailsDTO를 List로 넣어준다.
		// 9. 다 완성된 List<OrderDetailsDTO>를 orderInfoData로 넣어준다.
		// 10. 이 MyPageDTO를 컨트롤러로 반환한다.
		return null;
	}

	/**
	 * 서비스 목적
	 * - 회원이 자신의 정보를 보기 위해 제공하는 서비스
	 * - 컨트롤러에 MembersDTO를 반환해야 한다.
	 */
	@Override
	public MembersDTO showMyInfo(Long member_id) {
		// 1. MemberDAO에서 selectByMemberId로 MembersDTO에 값을 저장
		// 2. 저장한 MembersDTO의 값을 컨트롤러로 전달
		return null;
	}

	/**
	 * 서비스 목적
	 * - 회원이 자신의 정보 (비밀번호, 전화번호, 주소)를 바꾸기 위한 서비스
	 * - 컨트롤러에 영향받은 행의 수를 반환해야 한다.
	 */
	@Override
	public int editMyInfo(MembersDTO member) {
		// 1. MemberDAO에서 selectByMemberId로 MembersDTO에 값을 저장
		// 2. 수정된 membersDTO를 저장하기 위해 새로운 객체 생성
		// 3. 만약 값을 받은 member의 password가 빈칸이라면? 원본의 값을 가져오고
		// 3.1 암호는 암호화필요 (Spring Security)
		// 4. 만약 값을 받은 member의 phonenumber가 빈칸이라면? 원본의 값을 가져오고
		// 5. 만약 값을 받은 member의 address가 빈칸이라면? 원본의 값을 가져오고
		// 6. MemberDAO에 updateMembers로 새로 만든 MemberDTO 객체를 전달
		// 7. 만약 반환값이 1이 아니면 exception
		
		
		
		return 0;
	}
	
}
