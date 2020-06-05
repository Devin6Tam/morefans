package com.morefans.common.mybatis.common.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 基础业务接口
 * Created by tanxw on 2017/3/30.
 */
public interface IBaseService<T> {
    /**
     * 根据主键ID来查询
     * @param var1
     * @return
     */
    T selectByKey(Object var1);

    /**
     * 保存对象
     * 把所有值插入,但是要注意加入数据库字段有default,default是不会起作用的
     * @param var1
     * @return
     */
    int save(T var1);


    /**
     * 保存对象
     * 插入有值的数据，并且不会忽略数据库字段有default
     * @param var1
     * @return
     */
    int saveSelective(T var1);

    /**
     * 删除对象
     * @param var1
     * @return
     */
    int delete(Object var1);

    /**
     * 更新所有字段，慎用
     * @param var1
     * @return
     */
    int updateAll(T var1);

    /**
     * 更新不能空的字段
     * @param var1
     * @return
     */
    int updateNotNull(T var1);

    /**
     * 根据动态示例对象更新
     * @param var1 实体类
     * @param var2 动态sql示例对象
     * @return
     */
    int updateByExample(T var1, Example var2);

    /**
     * 查询列表
     * @param var1
     * @return
     */
    List<T> selectByList(Object var1);

    /**
     * 分页查询
     * 调用前，请先使用PageHelper.startPage(pageNum,pageSize)
     * 原理实现请查看：https://www.cnblogs.com/dengpengbo/p/10579631.html
     * @param var1
     * @return
     */
    PageInfo<T> selectByPage(Object var1);

    /**
     * 计数
     * @param var1
     * @return
     */
    int countByExample(Example var1);

    /**
     * 删除 慎用
     * @param var1
     * @return
     */
    int deleteByExample(Example var1);

    /**
     * 查询单个对象
     * @param var1
     * @return
     */
    T selectOne(Example var1);
}
