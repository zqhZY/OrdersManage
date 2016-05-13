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
* @date 2016-5-2 ����11:09:03
* @Description:��Ʒ��Ϣ������
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
	 * @date 2016-5-2  ����11:14:35
	 * @Description:������Ʒ������Ϣ
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/preview")
	public String PreviewItem(HttpSession session , Model model , Integer id){
		
		//System.out.println("userid = " + session.getAttribute("username"));
		//����id��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustom = itemService.getItemById(id);
		model.addAttribute("itemsCustom", itemsCustom);
		
		//�����û���Ϣ
		String username = (String) session.getAttribute("username");
		model.addAttribute("username", username);
		
		//��ȡ��һҳ��Ʒ��Ϣ
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
	 * @date 2016-5-2  ����4:35:23
	 * @Description:�����Ʒ�������û�������
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addOrder")
	public String AddToCart(HttpSession session , Model model ,Integer id) throws Exception {
			
		int userid = (Integer) session.getAttribute("userid");
		
		//����order��
		Orders orders = new Orders();
		
		orders.setUserId(userid);
		
		Date createtime=new Date();
		orders.setCreatetime(createtime);
		
		orders.setNumber("1");
		orders.setNote("first order");
		
		itemService.insertOrder(orders);
		
		System.out.println("test");
		
		
		//����id���ز�����id
		int ordersId = orders.getId();
		
		
		//���붩�������
		OrderDetialCustom orderDetial = new OrderDetialCustom();
		
		orderDetial.setItemsId(id);
		orderDetial.setOrdersId(ordersId);
		orderDetial.setItemsNum(1);
		
		itemService.insertOrderDetail(orderDetial);
				
		return "forward:/items/preview.action?id=" + id;
	}
	
	
}

