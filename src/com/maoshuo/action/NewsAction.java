package com.maoshuo.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.maoshuo.entity.News;
import com.maoshuo.entity.Student;
import com.maoshuo.service.NewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



@SuppressWarnings("rawtypes")
@SessionAttributes
public class NewsAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 1L;
	NewsService newsService;  
	private News news;//数据模型
	private String msg;
	
 public String query()  { 		
		 
		 List<News> news_list=new ArrayList<News>();		 
		 news_list=newsService.findAll();
		 if(news_list.size()>0) {
			 ActionContext.getContext().getSession().put("news_list",news_list);
			 msg="新闻信息查询成功！"; 			
		 }
		 else {
			 msg="新闻信息查询失败！数据库没有新闻。"; 			
		 }
		 return "news_gl";
 }	
 
 public String personQuery() {
	 System.out.println("新闻编号:"+news.getNewsID());
	 News news2=newsService.findById(news.getNewsID());
	 
	 List<String>news_info=new ArrayList<String>();
	 news_info.add(Integer.toString(news2.getNewsID()));
	 news_info.add(news2.getTitle());
	 news_info.add(news.getContent());
	 news_info.add(news2.getSubmitTime());
	 System.out.println("news_info:"+news_info.get(0)+"."+news_info.get(1)+"."+news_info.get(0)+"."+news_info.get(2));
	 ActionContext.getContext().getSession().put("news_info",news_info);
	 ActionContext.getContext().getSession().put("newsID",news_info.get(0));
	 msg="单个新闻查询成功，请修改";
	 return "modifyNews";
 }
 public String updatePerson() {
	 if(news!=null) { 
		 Calendar today=Calendar.getInstance();
		 String today_fomat=today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+today.get(Calendar.DAY_OF_MONTH)+" "+
				  today.get(Calendar.HOUR_OF_DAY)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND);
		 news.setSubmitTime(today_fomat);
		 newsService.update(news);
		 msg="新闻信息修改成功";
		 }
	 query();
	 return "news_gl";
	 
	 
 }
 public String delete() {
	 News news2 =newsService.findById(news.getNewsID());
	 if(news2!=null) {
		 newsService.delete(news2.getNewsID());
		 msg="新闻信息删除成功";
	 }
	 query();
	 return "news_gl";
 }
 
 
  public String add() {
	  boolean flag=false;
	  System.out.println("新闻标题:"+news.getTitle()+",新闻内容："+news.getContent());
	  Calendar today=Calendar.getInstance();
	  String today_fomat=today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+today.get(Calendar.DAY_OF_MONTH)+" "+
			  today.get(Calendar.HOUR_OF_DAY)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND);
	  news.setSubmitTime(today_fomat);
	  News news2=newsService.findByTitle(news.getTitle());
	  if(news2==null) {
		  flag=newsService.save(news);
		  if(flag) {
			  msg="添加成功";
		  }else {
			  msg="添加失败";
		  }
	  }
	  else { 
		  msg="新闻已存在，添加失败";
	  }
	  System.out.println("msg:"+msg);
	  query();
	  return "news_gl";
  }
     
     

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getMsg() {
		return msg;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public Object getModel() {
		  if(news==null)
			  news= new News();
		return news;
	}

	
	
	

}
