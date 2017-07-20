package com.controller.oracle;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.po.User;
import com.service.IUserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private SqlSessionFactory sqlSession; 

	//当加了@ResponseBody注解后将返回字符串 
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public @ResponseBody void findAll() {
		SqlSession openSession = sqlSession.openSession();
		Connection connection = openSession.getConnection();
		System.out.println(connection);
		
		List<User> users = userService.findAll();
		for (User user : users) {
			System.out.println(user.toString());
		}
		System.out.println(users);
	}

//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(User user, Model model) {
//		int id = userService.add(user);
//		model.addAttribute("id", id);
//		return "user";
//	}
//
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(User user, Model model) {
//		userService.update(user);
//		model.addAttribute("updateFlag", true);
//		return "user";
//	}
}
