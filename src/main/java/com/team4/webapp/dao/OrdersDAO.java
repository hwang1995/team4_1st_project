package com.team4.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.team4.webapp.dto.OrdersDTO;
import com.team4.webapp.dto.Pager;

@Mapper
public interface OrdersDAO {
	public List<OrdersDTO> selectOrdersList();
	public OrdersDTO selectByOrderId(Long order_id);
	public int insertOrders(OrdersDTO carts);
	public int updateOrders(OrdersDTO carts);
	public int deleteByOrderId(Long order_id);
	public List<OrdersDTO> selectByMemberId(Long member_id);
	public List<OrdersDTO> selectByPage(Pager pager);
	public int countOrders(Long member_id);
}
