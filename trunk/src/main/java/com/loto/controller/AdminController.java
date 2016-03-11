package com.loto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.Admin;
import com.loto.model.AdminExample;
import com.loto.service.AdminService;
import com.loto.service.BaseService;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController<Admin, AdminExample>{
	@Autowired
	private AdminService adminService;
	
	protected BaseService<Admin, AdminExample> getBaseService() {
		return adminService;
	}
	

}
