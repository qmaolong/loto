package com.loto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.User;
import com.loto.model.UserExample;
import com.loto.service.BaseService;
import com.loto.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User, UserExample>{
	@Autowired
	private UserService userService;
	
	protected BaseService<User, UserExample> getBaseService() {
		return userService;
	}
	
	
	

}
