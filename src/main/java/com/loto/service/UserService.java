package com.loto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loto.dao.BaseDao;
import com.loto.dao.UserMapper;
import com.loto.model.User;
import com.loto.model.UserExample;

@Component
@Transactional
@Service(value="userService")
public class UserService extends BaseService<User, UserExample>{
	@Autowired
	private UserMapper userDao;
	
	protected BaseDao<User, UserExample> getBaseDao() {
		return userDao;
	}

}
