package com.justzqh.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.justzqh.mapper.ItemsMapper;
import com.justzqh.mapper.ItemsMapperCustom;
import com.justzqh.mapper.OrderDetailMapperCustom;
import com.justzqh.mapper.OrderdetailMapper;
import com.justzqh.mapper.OrdersMapper;
import com.justzqh.mapper.OrdersMapperCustom;
import com.justzqh.po.Items;
import com.justzqh.po.ItemsCustom;
import com.justzqh.po.OrderDetialCustom;
import com.justzqh.po.Orderdetail;
import com.justzqh.po.Orders;
import com.justzqh.util.Page;

/**
 * 
* @Title: ItemServiceImp.java
* @author: zqh
* @date 2016-5-1 下午3:47:13
* @Description:商品信息service实现类
 */
public class ItemServiceImp implements ItemService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrdersMapperCustom ordersMapperCustom;
	
	
	@Autowired
	private OrderdetailMapper orderdetailMapper;
	@Autowired
	private OrderDetailMapperCustom orderDetailMapperCustom;
	
	public long getAllItemsCount() {
		// TODO Auto-generated method stub
		long itemsCount = itemsMapperCustom.getAllItemsCount(); 
		return itemsCount;
	}


	public List<ItemsCustom> getItems(Page page) {
		// TODO Auto-generated method stub
		List<ItemsCustom> items = itemsMapperCustom.getItems(page);
		return items;
	}


	public ItemsCustom getItemById(Integer id) {
		// TODO Auto-generated method stub
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		
		//复制items信息到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}


	public void insertOrder(Orders orders) {
		// TODO Auto-generated method stub	
		ordersMapper.insert(orders);
	}


	public void insertOrderDetail(OrderDetialCustom orderDetialCustom) {
		// TODO Auto-generated method stub
		Orderdetail orderdetail = new Orderdetail();
		BeanUtils.copyProperties(orderDetialCustom, orderdetail);
		
		orderdetailMapper.insert(orderdetail);
	}


	public List<Orders> getOrdersByUserId(Integer id) {
		// TODO Auto-generated method stub
		List<Orders> orderList = ordersMapperCustom.getOrdersByUserId(id);
		return orderList;
	}


	public List<Orderdetail> getDetailsByorderId(Integer id) {
		// TODO Auto-generated method stub
		List<Orderdetail> detailsList = orderDetailMapperCustom.getDetailsByorderId(id);
		return detailsList;
	}

}
