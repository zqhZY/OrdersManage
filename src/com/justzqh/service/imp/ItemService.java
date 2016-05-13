package com.justzqh.service.imp;

import java.util.List;

import com.justzqh.po.ItemsCustom;
import com.justzqh.po.OrderDetialCustom;
import com.justzqh.po.Orderdetail;
import com.justzqh.po.Orders;
import com.justzqh.util.Page;

/**
 * 
* @Title: ItemService.java
* @author: zqh
* @date 2016-5-1 下午3:44:15
* @Description:商品处理service接口
 */
public interface ItemService {

	//查询所有信息数量
	public long getAllItemsCount();
	
	//查询一页信息
	public List<ItemsCustom> getItems(Page page);
	
	//根据id查询商品信息
	public ItemsCustom getItemById(Integer id);
	
	//向order列表中插入一条记录
	public void insertOrder(Orders orders);
	
	
	//向订单详情表插入信息
	public void insertOrderDetail(OrderDetialCustom orderDetialCustom);
	
	
	//根据用户id查询订单信息
	public List<Orders> getOrdersByUserId(Integer id);
	
	//根据订单信息查询订单明细
	public List<Orderdetail> getDetailsByorderId(Integer id);
}
