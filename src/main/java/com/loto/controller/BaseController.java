package com.loto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.loto.service.BaseService;

public class BaseController<D, M, S extends BaseService<D, M>> {
	@Autowired
	private S service;
	
	@RequestMapping("list")
	public String list(String queryString, Integer pageNum, Integer pageSize, Model model){
		@SuppressWarnings("unchecked")
		M exam = (M)JSONObject.parseObject(queryString);
		model.addAttribute("list", service.findByExample(exam, pageNum, pageSize));
		return "";
	}
}
