package com.loto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.User;
import com.loto.model.UserExample;
import com.loto.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User, UserExample, UserService>{
	
	/*@RequestMapping("list")
	public String list(String queryString, Integer pageNum, Integer pageSize){
		AdminExample exam = new AdminExample();
		adminService.findByExample(exam, pageNum, pageSize);
		
		return "";
	}*/
	

}
