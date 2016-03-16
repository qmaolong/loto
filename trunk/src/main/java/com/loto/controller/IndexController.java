package com.loto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.Admin;
import com.loto.model.AdminExample;
import com.loto.service.AdminService;
import com.loto.service.BaseService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private AdminService adminService;
	
	protected BaseService<Admin, AdminExample> getBaseService() {
		return adminService;
	}
	
	@RequestMapping("/")
	public String index(){
		return "redirect:mission/hall";
	}

}
