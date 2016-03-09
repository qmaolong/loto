package com.loto.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.loto.dao.BaseDao;

public abstract class BaseService<D, M> {
	protected D entity;
	protected M example;
	
	public D findById(Long id){
		return (D) getBaseDao().selectByPrimaryKey(id);
	}
	
	public PageInfo<D> findByExample(M exam, Integer pageNum, Integer pageSize){
		List<D> list = getBaseDao().selectByExample(exam);
		PageInfo<D> pageInfo = new PageInfo<D>(list);
		
		return pageInfo;
	}
	
	public int save(D record){
		return getBaseDao().insert(record);
	}
	
	public int update(D record) {
		return getBaseDao().updateByPrimaryKey(record);
	}
	
	public int deleteByExample(M exam){
		return getBaseDao().deleteByExample(exam);
	}
	
	public int deleteById(Long id) {
		return getBaseDao().deleteByPrimaryKey(id);
	}
	
	protected abstract BaseDao<D, M> getBaseDao();

}
