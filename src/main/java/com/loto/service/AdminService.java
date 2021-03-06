package com.loto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loto.dao.AdminMapper;
import com.loto.dao.BaseDao;
import com.loto.model.Admin;
import com.loto.model.AdminExample;

@Component
@Transactional
@Service(value="adminService")
public class AdminService extends BaseService<Admin, AdminExample>{
	@Autowired
	private AdminMapper adminDao;
	
	protected BaseDao<Admin, AdminExample> getBaseDao() {
		return adminDao;
	}
	
}
