package com.morefans.mybatis.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.morefans.mybatis.common.service.IBaseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 基础业务实现
 * Created by tanxw on 2017/3/30.
 */
public class BaseService<T> implements IBaseService<T> {
    @Autowired
    protected Mapper<T> mapper;

    public BaseService() {
    }

    public Mapper<T> getMapper() {
        return this.mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return this.mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) {
        return this.mapper.insert(entity);
    }

    @Override
    public int saveSelective(T entity) {
        return this.mapper.insertSelective(entity);
    }

    @Override
    public int delete(Object key) {
        return this.mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(T entity) {
        return this.mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return this.mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByExample(T entity, Example example) {
        return this.mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public List<T> selectByList(Object example) {
        return this.mapper.selectByExample(example);
    }

    @Override
    public PageInfo<T> selectByPage(Object example) {
        List resutl = this.mapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(resutl);
        return pageInfo;
    }

    @Override
    public int countByExample(Example example) {
        return this.mapper.selectCountByExample(example);
    }

    @Override
    public int deleteByExample(Example example) {
        return this.mapper.deleteByExample(example);
    }

    @Override
    public T selectOne(Example example) {
        PageHelper.startPage(1, 1, false);
        List list = this.mapper.selectByExample(example);
        return list.isEmpty() ? null : (T) list.get(0);
    }
}
