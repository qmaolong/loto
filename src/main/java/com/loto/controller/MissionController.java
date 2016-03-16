package com.loto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loto.model.Mission;
import com.loto.model.MissionExample;
import com.loto.service.BaseService;
import com.loto.service.MissionService;
import com.loto.vo.PageInfo;

@Controller
@RequestMapping("mission")
public class MissionController extends BaseController<Mission, MissionExample>{
	@Autowired
	private MissionService missionService;
	
	protected BaseService<Mission, MissionExample> getBaseService() {
		return missionService;
	}
	
	@RequestMapping(value = {"/", "/hall"})
	public String hall(HttpServletRequest request, HttpServletResponse response, Model model){
		MissionExample example = new MissionExample();
		example.createCriteria().andRestCountGreaterThan(0L);
		int count = missionService.countByExample(example);
		model.addAttribute("count", count);
		return "/mission/hall";
	}
	
	protected MissionExample generateExamByEntity(Mission entity) {
		return null;
	}

}
