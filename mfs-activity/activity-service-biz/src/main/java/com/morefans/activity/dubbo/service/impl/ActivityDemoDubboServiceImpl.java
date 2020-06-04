package com.morefans.activity.dubbo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.morefans.activity.dubbo.service.ActivityDemoDubboService;
import com.morefans.activity.pojo.ActivityDemo;
import com.morefans.activity.response.vo.ActivityDemoBaseResponseVo;
import com.morefans.activity.service.ActivityDemoService;
import com.morefans.basic.core.base.ResponseResultManager;
import com.morefans.basic.core.util.ResponseResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tanxw
 * @date 2020/6/4
 */
@Component
@Service(timeout = 5000)
public class ActivityDemoDubboServiceImpl implements ActivityDemoDubboService {

    @Autowired
    private ActivityDemoService activityDemoService;

    @Override
    public ResponseResult<ActivityDemoBaseResponseVo> getDemobyId(Long id){
        ActivityDemo activityDemo = activityDemoService.selectByKey(id);
        ActivityDemoBaseResponseVo baseResponseVo = new ActivityDemoBaseResponseVo();
        BeanUtil.copyProperties(activityDemo,baseResponseVo);
        return ResponseResultManager.setResultSuccess(baseResponseVo);
    }
}
