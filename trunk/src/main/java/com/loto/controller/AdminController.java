package com.loto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.Admin;
import com.loto.model.AdminExample;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController<Admin, AdminExample>{
	

}
