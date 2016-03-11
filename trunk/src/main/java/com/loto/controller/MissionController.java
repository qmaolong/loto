package com.loto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.Mission;
import com.loto.model.MissionExample;
import com.loto.service.BaseService;
import com.loto.service.MissionService;

@Controller
@RequestMapping("mission")
public class MissionController extends BaseController<Mission, MissionExample>{
	@Autowired
	private MissionService missionService;
	
	protected BaseService<Mission, MissionExample> getBaseService() {
		return missionService;
	}
	
	
	

}
