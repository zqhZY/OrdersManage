package com.justzqh.mapper;

import java.util.List;

import com.justzqh.po.Orders;


public interface OrdersMapperCustom {

	public List<Orders> getOrdersByUserId(Integer id);
}
