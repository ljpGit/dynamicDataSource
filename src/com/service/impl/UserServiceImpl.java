package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.core.DataSourceInterceptor;
import com.core.DatabaseContextHolder;
import com.dao.IUserDao;
import com.pojo.po.User;
import com.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public List<User> findAll() {
		DatabaseContextHolder.setCustomerType("dataSourceOracle");
		return userDao.findAll();
	}

}
