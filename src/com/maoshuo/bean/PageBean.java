package com.maoshuo.bean;

import java.util.List;

public class PageBean<T> {
	private int page=1;
	private int totalCount;
	private int totalPage;
	private int limit;
	private List<T> list;
	public int getPage() {  
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}  
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		
		System.out.println("page-bean:"+page+",totalPage:"+totalPage);
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
