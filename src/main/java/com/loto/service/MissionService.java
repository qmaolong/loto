package com.loto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loto.dao.BaseDao;
import com.loto.dao.MissionMapper;
import com.loto.model.Mission;
import com.loto.model.MissionExample;

@Component
@Transactional
public class MissionService extends BaseService<Mission, MissionExample>{
	@Autowired
	private MissionMapper missionDao;
	
	protected BaseDao<Mission, MissionExample> getBaseDao() {
		return missionDao;
	}

}
