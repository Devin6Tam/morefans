package com.morefans.activity.entity;

import com.morefans.basic.core.base.BaseEntity;
import lombok.Data;

/**
 * 活动示例实体类
 * @author tanxw
 * @date 2020/6/2
 */
@Data
public class ActivityDemo extends BaseEntity{

    private Long id;
    private int diamond;
    private int ticket;
    private String message;

}
