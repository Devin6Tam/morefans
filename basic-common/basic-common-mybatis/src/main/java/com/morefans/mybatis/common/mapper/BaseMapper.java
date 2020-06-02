package com.morefans.mybatis.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by tanxw on 2017/1/5.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
