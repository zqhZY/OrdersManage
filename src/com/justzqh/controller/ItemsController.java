package com.justzqh.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justzqh.po.ItemsCustom;
import com.justzqh.po.OrderDetialCustom;
import com.justzqh.po.Orders;
import com.justzqh.service.imp.ItemService;
import com.justzqh.util.Page;


/**
 * 
* @Title: ItemsController.java
* @author: zqh
* @date 2016-5-2 上午11:09:03
* @Description:商品信息处理器
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemService itemService;
	

	/**
	 * 
	 * @Title:PreviewItem
	 * @author: zqh
	 * @date 2016-5-2  上午11:14:35
	 * @Description:返回商品详情信息
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/preview")
	public String PreviewItem(HttpSession session , Model model , Integer id){
		
		//System.out.println("userid = " + session.getAttribute("username"));
		//根据id查询物品信息
		ItemsCustom itemsCustom = itemService.getItemById(id);
		model.addAttribute("itemsCustom", itemsCustom);
		
		//跟踪用户信息
		String username = (String) session.getAttribute("username");
		model.addAttribute("username", username);
		
		//获取第一页商品信息
		int totalCount = (int) itemService.getAllItemsCount();
		Page page = new Page(totalCount, 1);
		List<ItemsCustom> items = itemService.getItems(page);
		model.addAttribute("items", items);
		return "/template/preview";	
	}
	
	
	/**
	 * 
	 * @Title:AddToCart
	 * @author: zqh
	 * @date 2016-5-2  下午4:35:23
	 * @Description:添加商品订单到用户订单表
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addOrder")
	public String AddToCart(HttpSession session , Model model ,Integer id) throws Exception {
			
		int userid = (Integer) session.getAttribute("userid");
		
		//插入order表
		Orders orders = new Orders();
		
		orders.setUserId(userid);
		
		Date createtime=new Date();
		orders.setCreatetime(createtime);
		
		orders.setNumber("1");
		orders.setNote("first order");
		
		itemService.insertOrder(orders);
		
		System.out.println("test");
		
		
		//自增id返回插入后的id
		int ordersId = orders.getId();
		
		
		//插入订单详情表
		OrderDetialCustom orderDetial = new OrderDetialCustom();
		
		orderDetial.setItemsId(id);
		orderDetial.setOrdersId(ordersId);
		orderDetial.setItemsNum(1);
		
		itemService.insertOrderDetail(orderDetial);
				
		return "forward:/items/preview.action?id=" + id;
	}
	
	
}

