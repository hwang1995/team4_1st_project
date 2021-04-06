<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>
<c:set var="mypageCount" value="${fn:length(mypage)}"></c:set>

    <section class="container-fluid">
        <article>
            <div class="mypage_myinfo">
                <div class="myinfo_top_content">
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-2">
                            <h1 class="eng_h1">My Info</h1>
                        </div>
                        <div class="col-5 myinfo_edit">
                            <h5 class="eng_h3"><a href="${contextPath}/account/edit-info">Edit</a></h5>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
                <div class="myinfo_content">
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Name</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_name}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Email</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_email}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Mobile</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_tel}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Address</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_address}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-2"></div>
                <div class="col-8 myinfo_bar"><span></span></div>
                <div class="col-2"></div>
            </div>

            <div class="row mt-3 mb-3">
                <div class="col-2"></div>
                <div class="col-8 mb-2">
                    <h2 class="eng_h2 order_list_title">Order list</h2>
                    <span class="ml-3 order_list_sub_title">
                        <h5>- 회원님의 최근주문 내역입니다.</h5>
                    </span>
                </div>
                <div class="col-2"></div>
            </div>

           

            <div class="mypage_table_container">
                <div class="col-2"></div>
                <div class="col-8">
                
                    <table class="table-bordered order_list_table">
                        <thead class="order_list_thead">
                       		<tr>
	                            <th scope="col" width="100">Order No.</th>
	                            <th scope="col" width="300">Product</th>
	                            <th scope="col" width="300">Description</th>
	                            <th scope="col" width="100">Quantity</th>
	                            <th scope="col" width="140">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:if test="${mypageCount > 0 }">
	                    		<c:forEach var="order" items="${mypage}">
			                          <tr>
			                            <td rowspan="${fn:length(order.myPageList)}">
			                                <fmt:formatDate value="${order.order_date}" pattern="yyyy-MM-dd"/><br/>
			                                <a href="${contextPath}/account/order-info?order_id=${order.order_id}" class="order_list_orderno">[${order.order_id}]</a>
			                            </td>
			                            <c:forEach var="orderlist" items="${order.myPageList}">
			                            <td>
			                                <a href="/webapp/product/${orderlist.product_id}">
			                                    <img src="${orderlist.product_image}" width="50%">
			                                </a>
			                            </td>
			                            <td>
			                               ${orderlist.product_name}<br/>
			                                Color : ${orderlist.product_color}<br/>
			                                Size : ${orderlist.product_size}
			                            </td>
			                            <td>${orderlist.product_quantity}</td>
			                            <td>KRW <fmt:formatNumber value="${orderlist.product_price}" pattern="#,###,###"/></td>
			                            </tr>
			                            </c:forEach>
			                   </c:forEach>
			                   <tr>
							   	<td colspan="5" class="text-center">
							   		<div class="d-flex justify-content-center">
								   		<div class="d-flex justify-content-center align-items-center" style="width:50%;">
									   		<!-- [처음][이전] 1 2 3 4 5 [다음][맨끝] -->
									   		<button class="btn btn-sm"
									   		   onclick="getList(1)" style="width:12%;">[처음]</button>
									   		
									   		<c:if test="${pager.groupNo>1}">
										   		<button class="btn btn-sm"
										   		   onclick="getList(${pager.startPageNo-1})" style="width:12%;">[이전]</button>
										   	</c:if>
									   		
									   		<c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}">
									   			<c:if test="${pager.pageNo!=i}">
									   				<button class="btn btn-outline-secondary btn-sm" onclick="getList(${i})" style="width:5%;height:60%;">${i}</button>
									   			</c:if>
									   			<c:if test="${pager.pageNo==i}">
									   				<button class="btn btn-secondary btn-sm" onclick="getList(${i})" style="width:5%;height:60%;">${i}</button>
									   			</c:if>
									   		</c:forEach>
									   		
									   		<c:if test="${pager.groupNo<pager.totalGroupNo}">
										   		<button class="btn btn-sm"
										   		   onclick="getList(${pager.endPageNo+1})" style="width:12%;">[다음]</button>
										   	</c:if>
										   	
									   		<button class="btn btn-sm"
									   		   onclick="getList(${pager.totalPageNo})" style="width:12%;">[맨끝]</button>
									   	</div>
								   	</div>
							   	</td>
							   </tr>
			                </c:if>
			                <c:if test="${mypageCount == 0 }">
				               	<tr>
				               		<td colspan="5" class="eng_h2" style="height : 50vh;">
				               		최근 주문 내역이 비어있습니다.
				               		</td>
				               	</tr>
				            </c:if>
                        </tbody>
                    </table>
                </div>
                <div class="col-2"></div>
            </div>
        </article>
    </section>