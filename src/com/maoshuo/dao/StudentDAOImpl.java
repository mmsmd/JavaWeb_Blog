package com.maoshuo.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.maoshuo.entity.Student;


public class StudentDAOImpl implements StudentDAO {
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
	public void save(Student student) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().save(student);
		getHt().flush();
	}

	// 删除客户
	public void delete(int id) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().delete(findById(id));
		getHt().flush();
	}

	// 更新客户
	public void update(Student student) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().merge(student);
		getHt().flush();
	}

	// 按id查找客户
	public Student findById(int id) {
		Student student = (Student) getHt().get(Student.class, new Integer(id));
		return student;
	}

	// 查找全部客户
	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		String queryString = "from Student";
		List<Student> list = (List<Student>) getHt().find(queryString);
		return list;
	}

	@Override
	public List<Student> findByName(String name) {
		String hsql = "from Student where name='" + name + "'";
		List<Student> result = (List<Student>) getHt().find(hsql);
		return result;		
	}

	@Override
	public Student findByXuehao(String xuehao) {
		Student student=null;
		String hsql = "from Student where xuehao='" + xuehao + "'";
		List<Student> result = (List<Student>) getHt().find(hsql);
		if(result.size()>0) {
			student=result.get(0);
		}
		return student;
	}
}
