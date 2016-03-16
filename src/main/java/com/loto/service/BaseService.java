package com.loto.service;

import java.util.List;

import com.loto.dao.BaseDao;
import com.loto.util.ValidatorUtil;
import com.loto.vo.PageInfo;

public abstract class BaseService<D, M> {
	
	public D findById(Long id){
		return (D) getBaseDao().selectByPrimaryKey(id);
	}
	
	public PageInfo<D> findByExample(M exam, Integer pageNum, Integer pageSize){
		if(ValidatorUtil.isNull(pageNum))
			pageNum = 1;
		if(ValidatorUtil.isNull(pageSize))
			pageSize = 10;
		com.github.pagehelper.PageHelper.startPage(pageNum, pageSize, true);
		List<D> list = getBaseDao().selectByExample(exam);
		PageInfo<D> pageInfo = new PageInfo<D>(list);
		
		return pageInfo;
	}
	
	public int countByExample(M exam){
		return getBaseDao().countByExample(exam);
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
