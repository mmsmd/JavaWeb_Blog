package com.maoshuo.action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.maoshuo.entity.Admin;
import com.maoshuo.entity.Student;
import com.maoshuo.service.AdminService;
import com.maoshuo.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("rawtypes")
@SessionAttributes
public class AdminAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 1L;
	AdminService adminService; 
	StudentService studentService; 
	private Admin admin;//数据模型
	private String msg;
	private Student student;
	private String xuehao;
	private String confirmPassword;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}

	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

     public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String login()  {
		
		System.out.println("管理员账号：" + admin.getAdminNumber()+ ",密码：" + admin.getAdminPassword());		
		Admin adm=adminService.findByXuehao(admin.getAdminNumber());		
		if(adm==null) {			
			msg="登录失败！用户不存在。";
			return "login";
			
		}
		else {
			if(adm.getAdminPassword().equals(admin.getAdminPassword())) {
				msg="登陆成功！";
				//System.out.println("adm学号：" + adm.getXuehao() + ",adm姓名：" + adm.getAdminName());
				ActionContext.getContext().getSession().put("adminNumber",adm.getAdminNumber());
				ActionContext.getContext().getSession().put("adminName",adm.getAdminName());
				
				return SUCCESS;
			}
			else {
				msg="密码错误，请重新输入";
				return "login";
			}
			

		}
		
		}	
   //****************************************************************************************
     public String modifyPassword()  {
 		
 		System.out.println("管理员账号：" + admin.getAdminNumber()+"密码：" +admin.getAdminPassword()+ ",确认密码：" + confirmPassword);
 		if(admin.getAdminPassword().equals(confirmPassword)) {
 	
 		Admin adm=adminService.findByXuehao(admin.getAdminNumber());		
 		if(adm==null) {			
 			msg="请先登录！";
 			return "login";
 			
 		}
 		else { 			
 			adm.setAdminPassword(confirmPassword);
 			System.out.println("admzhanghao：" + adm.getAdminNumber()+"adm密码：" +adm.getAdminPassword()+ ",adm姓名：" + adm.getAdminName());
 			adminService.update(adm);
 			msg="密码修改成功，请重修登录！"; 			
 			return "login";
 		}
 		}
 		else {
 			 msg="两次输入密码不一致，请重新输入！"; 
 		     return INPUT;
 		}
 		}	
     //****************************************************************************************
     public String personQuery()  { 		
 		System.out.println("管理员账号：" + admin.getAdminNumber()); 	
 		Admin adm=adminService.findByXuehao(admin.getAdminNumber());		
 		if(adm==null) {			
 			msg="请先登录！";
 			return "login"; 			
 		}
 		else { 			
 			List<String> admin_info=new ArrayList<String>();
 			admin_info.add(adm.getAdminNumber());
 			admin_info.add(adm.getAdminName());
 			admin_info.add(adm.getAdminPassword()); 			
 			admin_info.add(Integer.toString(adm.getAdminID()));
 			System.out.println("admin_info：" + admin_info.get(0)+"，" +admin_info.get(1)+ "," + admin_info.get(2));
 			ActionContext.getContext().getSession().put("admin_info",admin_info);
 			//ActionContext.getContext().getSession().put("admin",adm);
 			msg="个人信息查询成功！请修改下边个人信息："; 			
 			return "modifyPerson";
 		}
 		
 		
 }	
   //****************************************************************************************
     public String updatePerson()  { 		
    	
 		List<Student> list=new ArrayList();		
 		if(admin==null) {			
 			msg="请先登录！";
 			return "login"; 			
 		}
 		else {
 			System.out.println("updatePerson-zhanghao：" + admin.getAdminNumber() + ",updatePerson-姓名：" + admin.getAdminName());
 			adminService.update(admin); 			
 			msg="个人信息修改成功！";  			
 			return "modifyPerson";
 		}		
      }	 
     //**************************************************************************************** 
     public String query()  { 		
		 
		 List<Student> student_list=new ArrayList<Student>();		 
		 student_list=studentService.findAll();
		 if(student_list.size()>0) {
			 ActionContext.getContext().getSession().put("student_list",student_list);
			 msg="学生信息查询成功！"; 			
	  	     return "student_gl";
		 }
		 else {
			 msg="学生信息查询失败！数据库没有学生。"; 			
	  			return INPUT;
		 }
  		
       }	 
     //****************************************************************************************
     public String studentQuery()  {
    	 System.out.println("学号：" + xuehao); 	
  		Student stu=studentService.findByXuehao(xuehao);		
  		if(stu!=null) { 			
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
  			msg="学生信息查询成功！请修改如下个人信息："; 			
  			
  		}
  		return "student_edit";
 		
 }	
   //****************************************************************************************
     public String updateStudent()  { 		
    	  			
 		if(student!=null) {
 			System.out.println("updatePerson-学号：" + student.getXuehao() + ",updatePerson-姓名：" + student.getStudentName());
 			studentService.update(student); 			
 			msg="个人信息修改成功！"; 
 			query();
 		}
 		return "student_gl";
 		
 }	
   //****************************************************************************************
     public String studentDelete()  { 		
    	 System.out.println("学号：" + xuehao);		
 			Student stu=studentService.findByXuehao(xuehao);
 			if(stu!=null) {
 			System.out.println("studentDelete-学号：" + stu.getXuehao() + ",studentDelete-姓名：" + stu.getStudentName());
 			studentService.delete(stu.getStudentID());			
 			msg="个人信息修改成功！"; 			
 			}
 			query();
 		return "student_gl";
 		
 }	    
   //****************************************************************************************
     public String studentAdd()  { 		
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
 			msg="添加成功！"; 			
 			}
 			else
 			{
 				msg="添加失败！"; 				
 			}
 		}
 		else {
 			msg="用户已存在，添加失败！";
 			System.out.println("stu学号：" + stu.getXuehao() + ",stu姓名：" + stu.getStudentName()); 			
 		}
 		query();
		return "student_gl";
 		
 		
 }	      
     

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getMsg() {
		return msg;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public Object getModel() {
		  if(admin==null)
			  admin= new Admin();
		return admin;
	}
	
	
   

}
