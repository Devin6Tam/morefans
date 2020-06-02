package com.morefans.activity.request.vo;

import com.morefans.basic.core.base.BaseVo;
import lombok.Data;

/**
 * @author tanxw
 * @date 2020/6/2
 */
@Data
public class ActivityDemoBaseSearchVo extends BaseVo {

    private int beginTicket;

    private int endTicket;

    private String message;

}
