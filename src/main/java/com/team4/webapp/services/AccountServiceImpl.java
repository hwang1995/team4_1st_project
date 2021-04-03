package com.team4.webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.webapp.dao.OrderlistsDAO;
import com.team4.webapp.dao.OrdersDAO;
import com.team4.webapp.dao.ProductsDAO;
import com.team4.webapp.dto.MembersDTO;
import com.team4.webapp.dto.MyPageDTO;
import com.team4.webapp.dto.MyPageListDTO;
import com.team4.webapp.dto.OrderlistsDTO;
import com.team4.webapp.dto.OrdersDTO;
import com.team4.webapp.dto.ProductsDTO;

@Service
public class AccountServiceImpl implements IAccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	
	@Autowired
	private OrdersDAO ordersDAO;
	@Autowired
	private OrderlistsDAO orderlistsDAO;
	@Autowired
	private ProductsDAO productsDAO;
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
	public List<MyPageListDTO> showMyOrderInfo(Long member_id) {
		List<MyPageListDTO> mypageLists = new ArrayList<>();
		List<OrdersDTO> orders = ordersDAO.selectByMemberId(member_id);
		List<OrderlistsDTO> orderlists = new ArrayList<>();
		for(OrdersDTO order : orders) {
			List<MyPageDTO> mypageList = new ArrayList<MyPageDTO>();
			MyPageListDTO mypageInfoList = new MyPageListDTO();
			mypageInfoList.setOrder_id(order.getOrder_id());
			mypageInfoList.setOrder_date(order.getOrder_date());
			orderlists = orderlistsDAO.selectByOrderId(order.getOrder_id());
			for(OrderlistsDTO orderlist : orderlists) {
				ProductsDTO products = productsDAO.selectByProductId(orderlist.getProduct_id());
				MyPageDTO mypage = new MyPageDTO();
				mypage.setOrderInfo(orderlist);
				mypage.setProductsInfo(products);
				String filePath = "/webapp/image?path="+ mypage.getProduct_image();
				mypage.setProduct_image(filePath);
				mypageList.add(mypage);
				logger.info(mypage.toString());
			}
			mypageInfoList.setMyPageList(mypageList);
			mypageLists.add(mypageInfoList);
		}
		
		return mypageLists;
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
