<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>


<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${resources}/css/bootstrap.min.css"/>
	
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
	<script src="${resources}/js/bootstrap.bundle.min.js"></script>
	
	<!-- global style css 불러오기-->
	<link rel="stylesheet" href="${resources}/css/reset.css">
	<link rel="stylesheet" href="${resources}/css/common.css">
	
	<!-- header, footer css 불러오기 -->
	<link rel="stylesheet" href="${resources}/css/header.css">
	<link rel="stylesheet" href="${resources}/css/footer.css">

    <!-- 주문 완료 페이지 레이아웃 불러오기-->
    <link rel="stylesheet" href="${resources}/css/layout/order_checkout_layout.css">

    <title>Team4 - 결제 완료 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
<%-- 	<c:forEach var="item" items="${itemList}">
		${item.product_quantity }
		${item.product_size}
		${item.product_color}
		${item.product_id}
		<br/>
	</c:forEach> --%>
    <section>
        <article>
            <div class="container-sm order_info_margin">
                <form>
                	<input type="text" id="member_id" hidden value="${memberInfo.member_id}" />
                    <div class="order_info_toptext row">
                        <h2>주문 결제</h2>
                    </div>
                    <div class="order_info_line row">
                        <h4>주문자 정보</h4>
   
                    </div>
                    <div class="form-group row mt-2">
                        <label class="col-sm-2 col-form-label">이메일</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="member_email" disabled value="${memberInfo.member_email}">
                          
                        </div>
                    </div>
                    <div class="form-group row order_info_md_line">
                      <label for="member_name" class="col-sm-2 col-form-label">이름</label>
                      <div class="col-sm-5">
                        <input type="text" class="form-control" id="member_name" disabled value="${memberInfo.member_name }">
                      </div>
                    </div>
                    <div class="form-group row order_info_md_line">
                        <label for="member_address" class="col-sm-2 col-form-label">주소</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="member_address" disabled value="${memberInfo.member_address}">
                        </div>
                    </div>
                    <div class="form-group row order_info_md_line">
                        <label for="member_tel" class="col-sm-2 col-form-label">연락처</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="member_tel" disabled pattern="010-\d{3,4}-\d{4}" value="${memberInfo.member_tel }">
                        </div>
                    </div>
                    <div class="row order_info_bt_line"></div>
                </form>
                <form class="mt-5">
                    <div class="row order_info_bt_line pb-2">
                        <div class="col ml-n2">
                            <h4>배송 정보</h4>
                        </div>
                        <div class="col d-flex align-items-center justify-content-end">
                            <input type="checkbox" id="ucheckbox">
                            <h6 class="eng_h3 ml-2">위 정보와 같음</h6>
                        </div>
                    </div>
                    <div class="form-group row mt-2">
                      <label for="recipient_name" class="col-sm-2 col-form-label">이름</label>
                      <div class="col-sm-5">
                        <input type="text" class="form-control" id="recipient_name">
                      </div>
                    </div>
                    <div class="form-group row order_info_md_line">
                        <label for="recipient_address" class="col-sm-2 col-form-label">주소</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="recipient_address">
                        </div>
                    </div>
                    <div class="form-group row order_info_md_line">
                        <label for="recipient_tel" class="col-sm-2 col-form-label">연락처</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="recipient_tel" pattern="010-\d{3,4}-\d{4}">
                        </div>
                    </div>
                    <div class="row order_info_bt_line"></div>
                </form>
                <div class="mt-5">
                    <h4 class="row order_info_bt_line pb-2">주문 리스트</h4>
                    <div class="text-center">
                        <div>
                          <div class="row align-items-center order_info_bg_color">
                            <div class="col-2">제품</div>
                            <div class="col-4">이름</div>
                            <div class="col-2">색상</div>
                            <div class="col-1">사이즈</div>
                            <div class="col-1">수량</div>
                            <div class="col-2">가격</div>
                          </div>
                        </div>
                        <div>
                          <c:forEach var="item" items="${orderList}">
                          	<div class="row align-items-center order_info_list_line">
	                          	<div class="col-2"><img src="${item.product_image}" width="30%" /> </div>
	                            <div class="col-4">${item.product_name}</div>
	                            <div class="col-2">${item.product_color}</div>
	                            <div class="col-1">${item.product_size}</div>
	                            <div class="col-1">${item.product_quantity}</div>
	                            <div class="col-2">
	                            	<fmt:formatNumber value="${item.product_price}" pattern="#,###,###"/> &nbsp;
	                            </div>
                          	</div>
                          
                          </c:forEach>
         
                         
                          <div class="row align-items-center order_info_list_line order_info_bt_line">
                            <div class="col-9"></div>
                            <div class="col-3">
                            	<h6 class="font-weight-bold">
                          		  주문 금액 : <fmt:formatNumber value="${totalPrice}" pattern="###,###,###"/>&nbsp;원
                         		 </h6>
                         	</div>
                          </div>
                        </div>
                    </div>
                </div>
                <div class="mt-5">
                    <h4 class="row order_info_bt_line pb-2">주문상품 할인적용</h4>
                    <div class="text-center">
                        <div>
                          <div class="row align-items-center order_info_bg_color">
                            <div class="col-4">상품금액</div>
                            <div class="col-1"></div>
                            <div class="col-2">배송비</div>
                            <div class="col-1"></div>
                            <div class="col-4">결제 예정금액</div>
                          </div>
                        </div>
                        <div>
                          <div class="row align-items-center order_info_list_line order_info_bt_line">
                            <div class="col-4 order_info_font_size">
                            	<fmt:formatNumber value="${totalPrice}" pattern="###,###,###"/>&nbsp;원
                            </div>
                            <div class="col-1 order_info_font_size">+</div>
                            <div class="col-2 order_info_font_size">무료</div>
                            <div class="col-1 order_info_font_size">=</div>
                            <div class="col-4 order_info_font_size font-weight-bold">
                           	 <fmt:formatNumber value="${totalPrice}" pattern="###,###,###"/>&nbsp;원
                            </div>
                          </div>
                        </div>
                    </div>
                </div>
                <div class="mt-5">
                    <h4 class="row order_info_bt_line pb-2">결제 정보</h4>
                    <div class="text-center">
                        <div>
                          <div class="row align-items-center order_info_list_line">
                            <div class="col-2">결제방법</div>
                            <div class="col-2">가상계좌</div>
                            <div class="col-2">
                                <select name="bank_select" id="bank_select" style="width : 12rem;">
                                    <option selected disabled hidden>입금 은행 선택</option>
                                    <option value="kukmin">국민은행</option>
                                    <option value="sinhan">신한은행</option>
                                    <option value="nonghyeop">농협은행</option>
                                    <option value="uri">우리은행</option>
                                </select>
                            </div>
                            <div class="col-6"></div>
                          </div>
                        </div>
                        <div>
                            <div class="row align-items-center order_info_list_line order_info_bt_line">
                              <p>입금은행 선택 후 결제하기 클릭시 1회용 계좌가 생성되며 생성된 계좌로 [2일이내] 입금완료 시 입금확인이 처리됩니다.</p>
                              <p>※ 주의! 가상계좌 입금시, 반드시 은행 / 이름 / 금액이 꼭 일치해야 힙니다!</p>
                            </div>
                          </div>
                    </div>
                </div>
                <div class="mt-5">
                  <h4 class="row order_info_bt_line pb-2">주문자 동의</h4>
                  <div class="text-center">
                      <div class="row align-items-center order_info_list_line">
                        <div class="col-2">약관동의</div>
                        <div class="col-10">
                          <div class="row">
                            이용약관
                          </div>
                          <div class="row">
                            <div class="overflow-auto order_info_textbox">제 1 장 총 칙<br>제 1 조 (목적)<br>이 약관은 {COMPANY_NAME}(이하 "사이트"라 합니다)에서 제공하는 인터넷서비스(이하 "서비스"라 합니다)의 이용 조건 및 절차에 관한 기본적인 사항을 규정함을 목적으로 합니다.<br>제 2 조 (약관의 효력 및 변경)<br>① 이 약관은 서비스 화면이나 기타의 방법으로 이용고객에게 공지함으로써 효력을 발생합니다.
                              ② 사이트는 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 제1항과 같은 방법으로 공지 또는 통지함으로써 효력을 발생합니다.
                              <br>제 3 조 (용어의 정의)<br>
                              이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
                              <br>① 회원 : 사이트와 서비스 이용계약을 체결하거나 이용자 아이디(ID)를 부여받은 개인 또는 단체를 말합니다.
                              <br>② 신청자 : 회원가입을 신청하는 개인 또는 단체를 말합니다.
                              <br>③ 아이디(ID) : 회원의 식별과 서비스 이용을 위하여 회원이 정하고 사이트가 승인하는 문자와 숫자의 조합을 말합니다.
                              <br>④ 비밀번호 : 회원이 부여 받은 아이디(ID)와 일치된 회원임을 확인하고, 회원 자신의 비밀을 보호하기 위하여 회원이 정한 문자와 숫자의 조합을 말합니다.
                              <br> ⑤ 해지 : 사이트 또는 회원이 서비스 이용계약을 취소하는 것을 말합니다.
                              <br>
                              제 2 장 서비스 이용계약
                              <br>제 4 조 (이용계약의 성립)
                              <br>① 이용약관 하단의 동의 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다.
                              <br>② 이용계약은 서비스 이용희망자의 이용약관 동의 후 이용 신청에 대하여 사이트가 승낙함으로써 성립합니다.
                              <br>제 5 조 (이용신청)
                              <br>① 신청자가 본 서비스를 이용하기 위해서는 사이트 소정의 가입신청 양식에서 요구하는 이용자 정보를 기록하여 제출해야 합니다.
                              <br>② 가입신청 양식에 기재하는 모든 이용자 정보는 모두 실제 데이터인 것으로 간주됩니다. 실명이나 실제 정보를 입력하지 않은 사용자는 법적인 보호를 받을 수 없으며, 서비스의 제한을 받을 수 있습니다.
                              <br>제 6 조 (이용신청의 승낙)
                              <br>① 사이트는 신청자에 대하여 제2항, 제3항의 경우를 예외로 하여 서비스 이용신청을 승낙합니다.
                              <br>② 사이트는 다음에 해당하는 경우에 그 신청에 대한 승낙 제한사유가 해소될 때까지 승낙을 유보할 수 있습니다.
                              <br>가. 서비스 관련 설비에 여유가 없는 경우
                              <br>나. 기술상 지장이 있는 경우
                              <br> 다. 기타 사이트가 필요하다고 인정되는 경우
                              <br>③ 사이트는 신청자가 다음에 해당하는 경우에는 승낙을 거부할 수 있습니다.
                              <br>가. 다른 개인(사이트)의 명의를 사용하여 신청한 경우
                              <br>나. 이용자 정보를 허위로 기재하여 신청한 경우
                              <br>다. 사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청한 경우
                              <br>라. 기타 사이트 소정의 이용신청요건을 충족하지 못하는 경우
                              <br>제 7 조 (이용자정보의 변경)
                              <br>회원은 이용 신청시에 기재했던 회원정보가 변경되었을 경우에는, 온라인으로 수정하여야 하며 변경하지 않음으로 인하여 발생되는 모든 문제의 책임은 회원에게 있습니다.
                              <br>제 3 장 계약 당사자의 의무
                              <br>제 8 조 (사이트의 의무)
                              <br>① 사이트는 회원에게 각 호의 서비스를 제공합니다.
                              <br>가. 신규서비스와 도메인 정보에 대한 뉴스레터 발송
                              <br>나. 추가 도메인 등록시 개인정보 자동 입력
                              <br>다. 도메인 등록, 관리를 위한 각종 부가서비스
                              <br>② 사이트는 서비스 제공과 관련하여 취득한 회원의 개인정보를 회원의 동의없이 타인에게 누설, 공개 또는 배포할 수 없으며, 서비스관련 업무 이외의 상업적 목적으로 사용할 수 없습니다. 단, 다음 각 호의 1에 해당하는 경우는 예외입니다.
                              <br>가. 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우
                              <br>나. 범죄에 대한 수사상의 목적이 있거나 정보통신윤리 위원회의 요청이 있는 경우
                              <br>다. 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우
                              <br>③ 사이트는 이 약관에서 정한 바에 따라 지속적, 안정적으로 서비스를 제공할 의무가 있습니다.
                              <br>제 9 조 (회원의 의무)
                              <br>① 회원은 서비스 이용 시 다음 각 호의 행위를 하지 않아야 합니다.
                              <br>가. 다른 회원의 ID를 부정하게 사용하는 행위
                              <br>나. 서비스에서 얻은 정보를 사이트의 사전승낙 없이 회원의 이용 이외의 목적으로 복제하거나 이를 변경, 출판 및 방송 등에 사용하거나 타인에게 제공하는 행위
                              <br>다. 사이트의 저작권, 타인의 저작권 등 기타 권리를 침해하는 행위
                              <br>라. 공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형 등을 타인에게 유포하는 행위
                              <br>마. 범죄와 결부된다고 객관적으로 판단되는 행위
                              <br>바. 기타 관계법령에 위배되는 행위
                              <br>② 회원은 관계법령, 이 약관에서 규정하는 사항, 서비스 이용 안내 및 주의 사항을 준수하여야 합니다.
                              <br> ③ 회원은 내용별로 사이트가 서비스 공지사항에 게시하거나 별도로 공지한 이용 제한 사항을 준수하여야 합니다.
                              (시행일) 이 약관은 2015년 01월부터 시행합니다.</div>
                          </div>
                          <div class="row">
                            <div class="form-check form-check-inline">
                              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="gdpr_agree" value="gdpr_agree">
                              <label class="form-check-label" for="gdpr_agree">약관에 동의합니다.</label>
                            </div>
                            <div class="form-check form-check-inline">
                              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="gdpr_deny" value="gdpr_deny">
                              <label class="form-check-label" for="gdpr_deny">약관에 동의하지 않습니다.</label>
                            </div>
                          </div>
                          <div class="row mt-4"></div>
                          <div class="row">
                            개인정보 수집이용
                          </div>
                          <div>
                              <div>
                                <div class="row align-items-center order_info_bg_color">
                                  <div class="col-4">목적</div>
                                  <div class="col-4">항목</div>
                                  <div class="col-4">보유기간</div>
                                </div>
                              </div>
                              <div>
                                <div class="row align-items-center order_info_list_line order_info_bt_line">
                                  <div class="col-4">서비스제공(요금정산, 콘텐츠 제공, 구매 및 요금결제, 물품배송, 금융거래 본인 인증 및 금융서비스)</div>
                                  <div class="col-4">구매자 정보(이름, 연락처, 이메일), 수취인 정보(이름, 연락처, 주소)</div>
                                  <div class="col-4">주문일로부터 90일까지(관계법령에 따라 필요 시, 일정기간 보유)</div>
                                </div>
                              </div>
                          </div>
                          <div class="row">
                            동의하셔야 서비스를 이용할 수 있습니다.
                          </div>
                          <div class="row">
                            <div class="form-check form-check-inline">
                              <input class="form-check-input" type="radio" name="inlineRadioOptions2" id="info_agree" value="info_agree">
                              <label class="form-check-label" for="info_agree">정보 수집에 동의합니다.</label>
                            </div>
                            <div class="form-check form-check-inline">
                              <input class="form-check-input" type="radio" name="inlineRadioOptions2" id="info_deny" value="info_deny">
                              <label class="form-check-label" for="info_deny">동의하지 않습니다.</label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="row order_info_list_line order_info_bt_line">
                        <div class="col-2">
                          주문동의
                        </div>
                        <div class="col-10 d-flex ml-n3">
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="order_agree" >
                            <label class="form-check-label" for="order_agree">상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</label>
                          </div>
                        </div>
                      </div>
                  </div>
              </div>
              <div class="row mt-2 order_info_bg_color order_info_lastbox">
                <div class="col-2 text-center font-weight-bold">
                  최종 결제 금액
                </div>
                <div class="col-10 order_info_font_size">
                   <fmt:formatNumber value="${totalPrice}" pattern="###,###,###"/>&nbsp;원
                </div>
              </div>
              <div class="d-flex justify-content-center mt-2">
              
                  <button class="order_info_black_button">
                    <span class="h6">주문하기</span>
                  </button>
               
                <div class="ml-3 mr-3"></div>
                <a href="${contextPath}">
                  <button class="order_info_white_button">
                    <span class="h6">주문취소</span>
                  </button>
                </a>
               
              </div>
            </div>
        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>
    <script src="${resources}/js/checkout.js"></script>

</body>
</html>