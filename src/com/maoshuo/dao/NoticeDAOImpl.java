package com.maoshuo.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.maoshuo.bean.PageHibernateCallback;
import com.maoshuo.entity.Notice;


public class NoticeDAOImpl implements NoticeDAO {
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
	public void save(Notice notice) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().save(notice);
		getHt().flush();
	}

	// 删除客户
	public void delete(int id) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().delete(findById(id));
		getHt().flush();
	}

	// 更新客户
	public void update(Notice notice) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().merge(notice);
		getHt().flush();
	}

	// 按id查找客户
	public Notice findById(int id) {
		Notice notice = (Notice) getHt().get(Notice.class, new Integer(id));
		return notice;
	}

	// 查找全部客户
	@SuppressWarnings("unchecked")
	public List<Notice> findAll() {
		String queryString = "from Notice order by submitTime desc";
		List<Notice> list = (List<Notice>) getHt().find(queryString);
		return list;
	}


	@Override
	public Notice findByTitle(String title) {
		Notice notice=null;
		String hsql = "from Notice where title='" + title + "'";
		List<Notice> result = (List<Notice>) getHt().find(hsql);
		if(result.size()>0) {
			notice=result.get(0);
		}
		return notice;
	}

	@Override
	public int findTotalCount() {
		String hql="select count(*) from Notice";
		List<Long> list=(List<Long>) getHt().find(hql);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue(); 
		}
		return 0;
	}

	@Override
	public List<Notice> findByPageId(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="from Notice order by submitTime desc";
		@SuppressWarnings({"unchecked","rawtypes"})
		List<Notice> list=(List<Notice>) getHt().execute(new PageHibernateCallback(hql,new Object[] {},begin,limit));
		if(list != null && list.size()>0) {
			return list;
		}
		return null;
	}
}
