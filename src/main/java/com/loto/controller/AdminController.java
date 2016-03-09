package com.loto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.Admin;
import com.loto.model.AdminExample;
import com.loto.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("list")
	public String list(String queryString, Integer pageNum, Integer pageSize){
		AdminExample exam = new AdminExample();
		adminService.findByExample(exam, pageNum, pageSize);
		
		return "";
	}
	

}
