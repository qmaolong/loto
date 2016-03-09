package com.loto.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.loto.service.BaseService;

public class BaseController<D extends Serializable, M> {
	@Autowired
	private BaseService<D, M> service;
	
	@RequestMapping("list")
	@ResponseBody
	public PageInfo<D> list(String queryString, Integer pageNum, Integer pageSize){
		M exam = (M)JSONObject.parseObject(queryString);
		return service.findByExample(exam, pageNum, pageSize);
	}
}
