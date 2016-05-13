package com.justzqh.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justzqh.po.ItemsCustom;
import com.justzqh.po.Orderdetail;
import com.justzqh.po.Orders;
import com.justzqh.service.imp.ItemService;
import com.justzqh.util.Page;

/**
 * 
* @Title: HomeEnterController.java
* @author: zqh
* @date 2016-4-26 下午2:45:25
* @Description:
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 
	* @Title: HomeEnter
	* @author: zqh
	* @date 2016-4-22 涓嬪崍08:40:25
	* @Description:home浠庢澶勮繘鍏�
	* @return
	*http://iammr.7.blog.163.com/blog/static/49102699201222643458216/
	 */
	@RequestMapping("/")
	public String Home(HttpSession session, Model model, HttpServletRequest request) {

		//获取当前页数
		String pageNow = request.getParameter("pageNow");
		//分页工具类
		Page page = null;	
		//本页商品信息
		List<ItemsCustom> items = null;
		//获得总页数
		int itemsCount = (int) itemService.getAllItemsCount();
		
		//得到一页的列表信息
		if(pageNow != null){
			
			page = new Page(itemsCount, Integer.parseInt(pageNow));
			
			int pagePos = page.getStartPos();
			page.setStartPos(pagePos);
			
			items = itemService.getItems(page);
			
		}
		else {
			
			page = new Page(itemsCount , 1);
			items = itemService.getItems(page);
			
		}
		
		//向页面添加模型
		model.addAttribute("items", items);
		model.addAttribute("page" , page);
			
		//加载订单信息
		Integer userid = (Integer)session.getAttribute("userid");
		if(userid != null){
			
			//添加用户名
			String username = (String) session.getAttribute("username");
			model.addAttribute("username" , username);
			
			//查询该用户创建的订单
			List<Orders> orderList = itemService.getOrdersByUserId(userid);
			
			//遍历orderlist, 得到order_id列表
			List<Orderdetail> details = itemService.getDetailsByorderId(14);
			
			//根据order_id列表得到商品id列表
			
			
			//根据商品id列表得到商品信息列表
		}
		else {
			
		}
		
		//返回页面
		return "/index";
	}
	
}





