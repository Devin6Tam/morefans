package com.morefans.activity.request.vo;

import com.morefans.basic.core.base.BaseVo;
import lombok.Data;

/**
 * @author tanxw
 * @date 2020/6/2
 */
@Data
public class ActivityDemoBaseSearchVo extends BaseVo {

    /**
     * 范围  开始票数
     */
    private Integer beginTicket;

    /**
     * 范围  结束票数
     */
    private Integer endTicket;

    /**
     * 信息
     */
    private String message;

    /**
     * 当前页
     */
    private Integer pageNum = 1;


    /**
     * 当前大小
     */
    private Integer pageSize= 10;

}
