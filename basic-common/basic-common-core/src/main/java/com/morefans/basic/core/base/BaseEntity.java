package com.morefans.basic.core.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 * @author tanxw
 * @date 2020/6/2
 */
public class BaseEntity implements Serializable{

    private Date createTime;
    private Date updateTime;
}
