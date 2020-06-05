package com.morefans.basic.core.base;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 * @author tanxw
 * @date 2020/6/2
 */
@Data
public class BasePojo implements Serializable{

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
