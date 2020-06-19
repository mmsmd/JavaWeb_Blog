package com.maoshuo.service;

import java.util.List;

import com.maoshuo.dao.StudentDAO;
import com.maoshuo.entity.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	// 提供StudentDAO的注入通道
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public boolean save(Student student) {
		boolean flag=false;
		if(studentDAO.findById(student.getStudentID())==null) {
			studentDAO.save(student);//调用DAO对象保存
			flag=true;
	       }
		return flag;
	}
	@Override
	public void update(Student student) {
//		if(studentDAO.findById(student.getCid())!=null)
			studentDAO.update(student);		//调用DAO组件更新
	}

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();//调用DAO组件查询
	}
	

	@Override
	public List<Student> findByName(String name) {		
		return studentDAO.findByName(name); //调用DAO组件查询
	}

	@Override
	public Student findByXuehao(String xuehao) {
		return studentDAO.findByXuehao(xuehao); //调用DAO组件查询
	}

	@Override
	public void delete(int id) {
		if(studentDAO.findById(id)!=null)
			studentDAO.delete(id);			//调用DAO组件删除
		
	}
	

	@Override
	public Student findById(int id) {
		return studentDAO.findById(id);//调用DAO组件查询
	}

}
