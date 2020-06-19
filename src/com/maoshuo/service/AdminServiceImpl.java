package com.maoshuo.service;

import java.util.List;

import com.maoshuo.dao.AdminDAO;
import com.maoshuo.entity.Admin;

public class AdminServiceImpl implements AdminService {

	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	// 提供AdminDAO的注入通道
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public boolean save(Admin admin) {
		boolean flag=false;
		if(adminDAO.findById(admin.getAdminID())==null) {
			adminDAO.save(admin);//调用DAO对象保存
			flag=true;
	       }
		return flag;
	}
	@Override
	public void update(Admin admin) {
//		if(adminDAO.findById(admin.getCid())!=null)
			adminDAO.update(admin);		//调用DAO组件更新
	}

	@Override
	public List<Admin> findAll() {
		return adminDAO.findAll();//调用DAO组件查询
	}
	

	@Override
	public List<Admin> findByName(String name) {		
		return adminDAO.findByName(name); //调用DAO组件查询
	}

	@Override
	public Admin findByXuehao(String xuehao) {
		return adminDAO.findByXuehao(xuehao); //调用DAO组件查询
	}

	@Override
	public void delete(int id) {
		if(adminDAO.findById(id)!=null)
			adminDAO.delete(id);			//调用DAO组件删除
		
	}
	

	@Override
	public Admin findById(int id) {
		return adminDAO.findById(id);//调用DAO组件查询
	}

}
