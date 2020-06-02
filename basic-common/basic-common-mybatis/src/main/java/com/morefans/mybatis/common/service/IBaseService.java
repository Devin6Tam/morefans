package com.morefans.mybatis.common.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by tanxw on 2017/3/30.
 */
public interface IBaseService<T> {
    T selectByKey(Object var1);

    int save(T var1);

    int saveSelective(T var1);

    int delete(Object var1);

    int updateAll(T var1);

    int updateNotNull(T var1);

    int updateByExample(T var1, Example var2);

    List<T> selectByList(Object var1);

    PageInfo<T> selectByPage(Object var1);

    int countByExample(Example var1);

    int deleteByExample(Example var1);

    T selectOne(Example var1);
}
