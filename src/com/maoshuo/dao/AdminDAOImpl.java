package com.maoshuo.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.maoshuo.entity.Admin;


public class AdminDAOImpl implements AdminDAO {
	private SessionFactory sessionFactory;
	private HibernateTemplate ht;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 为注入sessionFactory Bean准备的setter方法
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHt() {
		if (ht == null)
			ht = new HibernateTemplate(sessionFactory);
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	// 添加客户
	public void save(Admin admin) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().save(admin);
		getHt().flush();
	}

	// 删除客户
	public void delete(int id) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().delete(findById(id));
		getHt().flush();
	}

	// 更新客户
	public void update(Admin admin) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().merge(admin);
		getHt().flush();
	}

	// 按id查找客户
	public Admin findById(int id) {
		Admin admin = (Admin) getHt().get(Admin.class, new Integer(id));
		return admin;
	}

	// 查找全部客户
	@SuppressWarnings("unchecked")
	public List<Admin> findAll() {
		String queryString = "from Admin";
		List<Admin> list = (List<Admin>) getHt().find(queryString);
		return list;
	}

	@Override
	public List<Admin> findByName(String name) {
		String hsql = "from Admin where adminName='" + name + "'";
		List<Admin> result = (List<Admin>) getHt().find(hsql);
		return result;		
	}

	@Override
	public Admin findByXuehao(String xuehao) {
		Admin admin=null;
		String hsql = "from Admin where adminNumber='" + xuehao + "'";
		List<Admin> result = (List<Admin>) getHt().find(hsql);
		if(result.size()>0) {
			admin=result.get(0);
		}
		return admin;
	}
}
