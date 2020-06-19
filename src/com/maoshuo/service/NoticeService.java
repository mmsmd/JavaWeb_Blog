package com.maoshuo.service;

import java.util.List;

import com.maoshuo.bean.PageBean;
import com.maoshuo.entity.Notice;



public interface NoticeService {
	public boolean save(Notice news); // 添加客户
	public Notice findByTitle(String title);// 按客户名查找客户
	public void delete(int id);// 删除客户
	public void update(Notice news); // 更新客户
	public Notice findById(int id);// 按id查找客户
	public List<Notice> findAll();// 查找全部客户
	public PageBean<Notice> findByPage(int page);
}
