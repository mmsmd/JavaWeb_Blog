package com.maoshuo.action;

import java.util.ArrayList;

import java.util.List;

import com.maoshuo.entity.News;
import com.maoshuo.entity.Notice;
import com.maoshuo.service.NewsService;
import com.maoshuo.service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowIndexAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	NewsService newsService;
	NoticeService noticeService;
	private String msg;
	
	@Override
	public String execute() throws Exception{
		List<News> news_list=new ArrayList<News>();
		news_list=newsService.findAll();
		if(news_list.size()>0) {
			if(news_list.size()>=5)
				news_list=news_list.subList(0,3);
			ActionContext.getContext().getSession().put("news_list",news_list);
			msg="新闻信息 查询成功";
		}else {
			msg="新闻信息查询失败！";
		}
		
		List<Notice> notice_list=new ArrayList<Notice>();
			notice_list=noticeService.findAll();
			if(notice_list.size()>0) {
				if(notice_list.size()>=5)
					notice_list=notice_list.subList(0,3);
				ActionContext.getContext().getSession().put("notice_list",notice_list);
				msg="通知信息 查询成功";
			}else {
				msg="通知信息查询失败！";
			}
			return SUCCESS;
	}
	
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public NoticeService getNoticeservice() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}