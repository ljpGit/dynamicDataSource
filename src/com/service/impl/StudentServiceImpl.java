package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.core.DatabaseContextHolder;
import com.dao.IStudentDao;
import com.pojo.po.Student;
import com.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{

	@Resource
	private IStudentDao studentDao;
	
	@Override
	public List<Student> findAll() {
		
		DatabaseContextHolder.setCustomerType("dataSourceMysql");
		
		List<Student> findAll = studentDao.findAll();
		
		return findAll;
	}

/*	@Resource
	private IStudentDao studentDao;

	public Student get(int id) {
		return studentDao.get(id);
	}

	public int add(Student student) {
		return studentDao.add(student);
	}

	public void delete(int id) {
		studentDao.delete(id);
	}*/
}
