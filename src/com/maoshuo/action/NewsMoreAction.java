package com.maoshuo.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.maoshuo.bean.PageBean;
import com.maoshuo.entity.News;
import com.maoshuo.service.NewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewsMoreAction extends ActionSupport implements ModelDriven<News>,ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private NewsService newsService;
		private News news=new News();
		HttpServletRequest request;
		private String flag;
		private int page;
		private int totalPage;

		@Override
		public String execute() throws Exception{
			if(flag!=null) {
				System.out.println("pagebeanAction-000:"+page+","+flag);
				if(flag.equals("add")) {
					page=page+1;
					System.out.println("pagebeanAction-add:"+page+","+flag);
				}
				else if(flag.equals("sub")) {
					page=page-1;
					System.out.println("pagebeanAction-sub  :"+page+","+flag);
				}
			}
			if(page<=0)
				page=1;
			else {
				if(page>totalPage) {
					page=totalPage;
					System.out.println("pagebeanAction-flag:"+page+","+flag);
				}
			}
			System.out.println("pagebeanAction-page:"+page+","+flag);
			PageBean<News> pagebean=newsService.findByPage(page);
			totalPage=pagebean.getTotalPage();
			ActionContext.getContext().getValueStack().set("pageBean", pagebean);
			return "newsMore";
		}

		public NewsService getNewsService() {
			return newsService;
		}

		public void setNewsService(NewsService newsService) {
			this.newsService = newsService;
		}

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public News getModel() {
			return news;
		}

		@Override
		public void setServletRequest(HttpServletRequest request) {
			this.request=request;
			
		}
		
		
	
		
		
		
		
		
}

