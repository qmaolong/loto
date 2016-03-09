package com.loto.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<D extends Serializable, M> {
	int countByExample(M example);

    int deleteByExample(M example);

    int deleteByPrimaryKey(Long id);

    int insert(D record);

    int insertSelective(D record);

    List<D> selectByExample(M example);

    D selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") D record, @Param("example") M example);

    int updateByExample(@Param("record") D record, @Param("example") M example);

    int updateByPrimaryKeySelective(D record);

    int updateByPrimaryKey(D record);

}
