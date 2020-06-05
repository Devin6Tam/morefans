package com.morefans.common.mybatis.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础mapper类
 * Created by tanxw on 2017/1/5.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
