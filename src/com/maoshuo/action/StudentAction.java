package com.maoshuo.action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.maoshuo.entity.Student;
import com.maoshuo.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



@SuppressWarnings("rawtypes")
@SessionAttributes
public class StudentAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 1L;
	StudentService studentService;  
	private Student student;//数据模型
	private String msg;
	private String confirmPassword;
	//Map<String, Object> session= ActionContext.getContext().getSession();
	//HttpSession session=ServletActionContext.getRequest().getSession();
	
	//HttpSession session=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	
	
//	注册
	public String register()  {
		boolean flag=false;
		System.out.println("学号：" + student.getXuehao() + ",姓名：" + student.getStudentName());
		if(student.getSex().equals("1"))
			student.setSex("男");
		else
			student.setSex("女");		
		Student stu=studentService.findByXuehao(student.getXuehao());
		if(stu==null) {
			flag = studentService.save(student);
			if(flag) {
			msg="注册成功！";
			return "login";
			}
			else
			{
				msg="注册失败！";
				return INPUT;
			}
		}
		else {
			msg="用户已存在，注册失败！";
			System.out.println("stu学号：" + stu.getXuehao() + ",stu姓名：" + stu.getStudentName());
			return INPUT;
		}	
	}

//登陆
     public String login()  {
		
		System.out.println("学号：" + student.getXuehao()+ ",密码：" + student.getPassword());		
		Student stu=studentService.findByXuehao(student.getXuehao());		
		if(stu==null) {			
			msg="登录失败！用户不存在。";
			return "login";
			
		}
		else {
			if(stu.getPassword().equals(student.getPassword())) {
				msg="登陆成功！";
				//System.out.println("stu学号：" + stu.getXuehao() + ",stu姓名：" + stu.getStudentName());
				ActionContext.getContext().getSession().put("xuehao",stu.getXuehao());
				ActionContext.getContext().getSession().put("userName",stu.getStudentName());
				ActionContext.getContext().getSession().put("stu",stu);
				return SUCCESS;
			}
			else {
				msg="密码错误，请重新输入";
				return "login";
			}
			
//			session.setAttribute("userName", stu.getStudentName());
//			session.setAttribute("xuehao", stu.getXuehao());
			//session.put("userName", stu.getStudentName());
			//session.put("xuehao", stu.getXuehao());
			//student.setXuehao(stu.getXuehao());
			//ServletActionContext.getRequest().setAttribute("xuehao",stu.getXuehao());
			
			//ServletActionContext.getRequest().setAttribute("userName",stu.getStudentName());
		}
		
		}	
   //****************************************************************************************
//   修改密码
     public String modifyPassword()  {
 		//student.setXuehao((String)session.get("xuehao"));
    	 //student.setXuehao((String)session.getAttribute("xuehao"));
    	 String xuehao= (String) ActionContext.getContext().getSession().get("xuehao");
 		System.out.println("学号：" + xuehao +"密码：" +student.getPassword()+ ",确认密码：" + confirmPassword);
 		if(student.getPassword().equals(confirmPassword)) {
 	
 		Student stu=studentService.findByXuehao(xuehao);		
 		if(stu==null) {			
 			msg="请先登录！";
 			return "login";
 			
 		}
 		else { 			
 			stu.setPassword(confirmPassword);
 			System.out.println("stu学号：" + stu.getXuehao()+"stu密码：" +stu.getPassword()+ ",stu姓名：" + stu.getStudentName());
 			studentService.update(stu);
 			msg="密码修改成功，请重新登录！"; 			
 			return "login";
 		}
 		}
 		else {
 			 msg="两次输入密码不一致，请重新输入！"; 
 		     return INPUT;
 		}
 		}	
     //****************************************************************************************
//  查询个人信息
     public String personQuery()  { 		
    	String xuehao= (String) ActionContext.getContext().getSession().get("xuehao");
 		System.out.println("学号：" + xuehao); 	
 		Student stu=studentService.findByXuehao(xuehao);		
 		if(stu==null) {			
 			msg="请先登录！";
 			return "login"; 			
 		}
 		else { 			
 			List<String> student_info=new ArrayList<String>();
 			student_info.add(stu.getXuehao());
 			student_info.add(stu.getStudentName());
 			student_info.add(stu.getPassword());
 			student_info.add(stu.getSex());
 			student_info.add(stu.getBanji());
 			student_info.add(stu.getBirthday());
 			student_info.add(Integer.toString(stu.getStudentID()));
 			System.out.println("student_info：" + student_info.get(0)+"，" +student_info.get(1)+ "," + student_info.get(2));
 			ActionContext.getContext().getSession().put("student_info",student_info);
 			//ActionContext.getContext().getSession().put("student",stu);
 			msg="个人信息查询成功！请修改下边个人信息："; 			
 			return "modifyPerson";
 		}
 		
 		
 }	
   //****************************************************************************************
//  修改个人信息
     public String updatePerson()  { 		
    	  			
 		if(student==null) {			
 			msg="请先登录！";
 			return "login"; 			
 		}
 		else {
 			System.out.println("updatePerson-学号：" + student.getXuehao() + ",updatePerson-姓名：" + student.getStudentName());
 			studentService.update(student); 			
 			msg="个人信息修改成功！"; 			
 			return "modifyPerson";
 		}
 		
 		
 }	 
    
     
     

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getMsg() {
		return msg;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public Object getModel() {
		  if(student==null)
			  student= new Student();
		return student;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public void validate(){
    	System.out.println("validate");
    	//age值必须在18-26之间
    	if(student.getPassword()!=null)
    		if (student.getPassword().length()<6||student.getPassword().length()>20)
    	{
    		addFieldError("password", "用户密码必须在6到20位之间!");//返回“INPUT”逻辑视图
    	}
    	if(student.getXuehao()!=null)
    		if (student.getXuehao().length()!=11)
    	{
    		addFieldError("xuehao", "学号必须是11位的数字!");//返回“INPUT”逻辑视图
    	}
    	if(student.getStudentName()!=null)
		    if(student.getStudentName().length()==0)
    	{
    		addFieldError("studentName", "姓名不能为空!");//返回“INPUT”逻辑视图
    	}
    	if(student.getBanji()!=null)
	         if(student.getBanji().length()==0)
    	{
    		addFieldError("banji", "班级不能为空!");//返回“INPUT”逻辑视图
    	}
    	if(student.getBirthday()!=null)
        if(student.getBirthday().length()==0)
    	{
    		addFieldError("birthday", "生日不能为空!");//返回“INPUT”逻辑视图
    	}
    }

}
