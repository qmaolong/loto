package com.loto.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.loto.dao.BaseDao;

public class BaseService<D extends Serializable, M> {
	private BaseDao<D, M> dao;
	protected D entity;
	protected M example;
	
	public D findById(Long id){
		return dao.selectByPrimaryKey(id);
	}
	
	public PageInfo<D> findByExample(M exam, Integer pageNum, Integer pageSize){
		List<D> list = dao.selectByExample(exam);
		PageInfo<D> pageInfo = new PageInfo<D>(list);
		
		return pageInfo;
	}
	
	public int save(D record){
		return dao.insert(record);
	}
	
	public int update(D record) {
		return dao.updateByPrimaryKey(record);
	}
	
	public int deleteByExample(M exam){
		return dao.deleteByExample(exam);
	}
	
	public int deleteById(Long id) {
		return dao.deleteByPrimaryKey(id);
	}
	
	public void setBaseDao(BaseDao<D, M> baseDao) {
		this.dao = baseDao;
	}

}
