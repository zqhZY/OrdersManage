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
* @date 2016-5-1 ����3:44:15
* @Description:��Ʒ����service�ӿ�
 */
public interface ItemService {

	//��ѯ������Ϣ����
	public long getAllItemsCount();
	
	//��ѯһҳ��Ϣ
	public List<ItemsCustom> getItems(Page page);
	
	//����id��ѯ��Ʒ��Ϣ
	public ItemsCustom getItemById(Integer id);
	
	//��order�б��в���һ����¼
	public void insertOrder(Orders orders);
	
	
	//�򶩵�����������Ϣ
	public void insertOrderDetail(OrderDetialCustom orderDetialCustom);
	
	
	//�����û�id��ѯ������Ϣ
	public List<Orders> getOrdersByUserId(Integer id);
	
	//���ݶ�����Ϣ��ѯ������ϸ
	public List<Orderdetail> getDetailsByorderId(Integer id);
}
