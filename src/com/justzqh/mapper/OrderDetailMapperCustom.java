package com.justzqh.mapper;

import java.util.List;

import com.justzqh.po.Orderdetail;

/**
 * 
* @Title: OrderDetailMapperCustom.java
* @author: zqh
* @date 2016-5-2 ����8:36:19
* @Description:
 */
public interface OrderDetailMapperCustom {

	public List<Orderdetail> getDetailsByorderId(Integer id);
}
