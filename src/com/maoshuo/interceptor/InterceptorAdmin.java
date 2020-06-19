package com.maoshuo.interceptor;
import com.maoshuo.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class InterceptorAdmin extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	private String admin;
	public String intercept(ActionInvocation invocation) throws Exception {
		 System.out.println("	第一个拦截器，在调用下一个拦截器 或Action前");  //输出
		 admin=(String)ActionContext.getContext().getSession().get("adminName"); 
		 //System.out.println("login2-000：" + admin);
	    	if(admin==null||admin.equals("")) {
	    		//System.out.println("login2：" + admin);	
	    		return "login";	    		
	    		}
		 String result = invocation.invoke();      							 //调用下一个拦截器
		 System.out.println("	第一个拦截器，在调用下一个拦截器 或Action后");  //输出
		 return result; 												 //返回调用结果
	}
}
