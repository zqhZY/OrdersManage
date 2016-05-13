package com.justzqh.util;

/**
 * 
* @Title: Page.java
* @author: zqh
* @date 2016-5-1 下午3:09:45
* @Description:分页工具类
 */
public class Page {
	
	private int pageNow = 1;
	private int pageSize = 4;
	private int totalCount;
	
	@SuppressWarnings("unused")
	private int totalPageCount;
	
	
	public Page(int totalCount , int pageNow){
		
		this.pageNow = pageNow;
		this.totalCount = totalCount;
	}
	
	
	@SuppressWarnings("unused")
	private int startPos;

	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		
		//要用get、set方法获取，否则不会更新！！！！
		if (getTotalCount() % getPageSize() == 0) {
			
			return getTotalCount()/getPageSize();
		}
		else {
			
			return getTotalCount()/getPageSize() + 1;
		}
		
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartPos() {
		
		return (getPageNow() - 1) * getPageSize();
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
	

}
