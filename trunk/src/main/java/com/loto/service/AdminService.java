package com.loto.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loto.dao.AdminMapper;
import com.loto.model.Admin;
import com.loto.model.AdminExample;

@Component
@Transactional
public class AdminService extends BaseService<Admin, AdminExample>{
	
}
