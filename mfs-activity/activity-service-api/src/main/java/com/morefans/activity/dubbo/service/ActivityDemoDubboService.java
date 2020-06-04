package com.morefans.activity.dubbo.service;

import com.morefans.activity.response.vo.ActivityDemoBaseResponseVo;
import com.morefans.basic.core.util.ResponseResult;

/**
 * 活动示例Dubbo服务
 * @author tanxw
 * @date 2020/6/4
 */
public interface ActivityDemoDubboService {

    /**
     * 获取活动示例
     * @param id
     * @return
     */
    ResponseResult<ActivityDemoBaseResponseVo> getDemobyId(Long id);

}
