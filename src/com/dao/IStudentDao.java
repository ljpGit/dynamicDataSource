package com.dao;

import java.util.List;

import com.pojo.po.Student;

public interface IStudentDao {
	
	List<Student> findAll();

/*	Student get(int id);

	int add(Student student);

	void delete(int id);*/
}
