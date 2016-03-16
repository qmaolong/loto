package com.loto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.loto.common.ResultMsg;
import com.loto.service.BaseService;
import com.loto.util.ValidatorUtil;

public abstract class BaseController<D, M> {
	private M exam;
	private Integer DEFAULT_PAGENUM = 1;
	private Integer DEFAULT_PAGESIZE = 10;
	
	@RequestMapping("list")
	@ResponseBody
	public ResultMsg list(String queryString, Integer pageNum, Integer pageSize){
		if(ValidatorUtil.isNull(pageNum))
			pageNum = DEFAULT_PAGENUM;
		if(ValidatorUtil.isNull(pageSize))
			pageSize = DEFAULT_PAGESIZE;
		try {
			@SuppressWarnings("unchecked")
			D entity = (D)JSONObject.parseObject(queryString);
			exam = generateExamByEntity(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResultMsg.buildResultMsg(getBaseService().findByExample(exam, pageNum, pageSize));
	}
	
	protected abstract BaseService<D, M> getBaseService();
	
	protected M generateExamByEntity(D entity) {
		return null;
	}
}
