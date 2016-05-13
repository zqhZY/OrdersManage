package com.justzqh.mapper;

import java.util.List;

import com.justzqh.po.ItemsCustom;
import com.justzqh.util.Page;

/**
 * 
* @Title: ItemsMapperCustom.java
* @author: zqh
* @date 2016-5-1 下午3:31:52
* @Description:商品信息拓展类
 */
public interface ItemsMapperCustom {
	
	//得到全部记录数量
	public long getAllItemsCount();
	
	//获取当前页物品信息
	public List<ItemsCustom> getItems(Page page);
	
	

}
