package com.loto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.loto.service.BaseService;

public abstract class BaseController<D, M> {
	
	@RequestMapping("list")
	public String list(String queryString, Integer pageNum, Integer pageSize, Model model){
		@SuppressWarnings("unchecked")
		M exam = (M)JSONObject.parseObject(queryString);
		model.addAttribute("list", getBaseService().findByExample(exam, pageNum, pageSize));
		return "";
	}
	
	protected abstract BaseService<D, M> getBaseService();
}
