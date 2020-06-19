package com.maoshuo.service;

import java.util.List;

import com.maoshuo.bean.PageBean;
import com.maoshuo.dao.NoticeDAO;
import com.maoshuo.entity.Notice;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDAO noticeDAO;

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	// 提供NoticeDAO的注入通道
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public boolean save(Notice notice) {
		boolean flag=false;
		if(noticeDAO.findById(notice.getNoticeID())==null) {
			noticeDAO.save(notice);//调用DAO对象保存
			flag=true;
	       }
		return flag;
	}
	@Override
	public void update(Notice notice) {
//		if(noticeDAO.findById(notice.getCid())!=null)
			noticeDAO.update(notice);		//调用DAO组件更新
	}

	@Override
	public List<Notice> findAll() {
		return noticeDAO.findAll();//调用DAO组件查询
	}
	
	@Override
	public Notice findByTitle(String title) {
		return noticeDAO.findByTitle(title); //调用DAO组件查询
	}

	@Override
	public void delete(int id) {
		if(noticeDAO.findById(id)!=null)
			noticeDAO.delete(id);			//调用DAO组件删除
		
	}
	

	@Override
	public Notice findById(int id) {
		return noticeDAO.findById(id);//调用DAO组件查询
	}

	@Override
	public PageBean<Notice> findByPage(int page) {
		// TODO Auto-generated method stub 
		PageBean<Notice>pageBean=new PageBean<Notice>();
		pageBean.setPage(page);
		int limit=10;
		pageBean.setLimit(limit);
		int totalCount=noticeDAO.findTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalpage=(int)Math.ceil(totalCount/limit)+1;
		pageBean.setTotalPage(totalpage);
		int begin=(page-1)*limit;
		List<Notice>list=noticeDAO.findByPageId(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

} 
