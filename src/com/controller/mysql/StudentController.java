package com.controller.mysql;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.po.Student;
import com.service.IStudentService;

@Controller
@RequestMapping("/student/")
public class StudentController {

	@Resource
	private IStudentService studentService;
	
	@Resource
	private SqlSessionFactory sqlSession;

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public void get() {
		SqlSession openSession = sqlSession.openSession();
		Connection connection = openSession.getConnection();
		System.out.println(connection);
		
		List<Student> findAll = studentService.findAll();
		for (Student student : findAll) {
			System.out.println(student.toString());
		}
	}

//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(Student student, Model model) {
//		int id = studentService.add(student);
//		model.addAttribute("id", id);
//		return "student";
//	}
//
//	@RequestMapping(value = "delete", method = RequestMethod.POST)
//	public String delete(@RequestParam Integer id, Model model) {
//		studentService.delete(id);
//		model.addAttribute("delFlag", true);
//		return "student";
//	}
}
