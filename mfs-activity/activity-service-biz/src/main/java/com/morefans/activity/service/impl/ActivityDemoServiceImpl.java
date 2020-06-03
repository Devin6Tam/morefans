package com.morefans.activity.service.impl;

import com.morefans.activity.entity.ActivityDemo;
import com.morefans.activity.mapper.ActivityDemoMapper;
import com.morefans.activity.service.IActivityDemoService;
import com.morefans.mybatis.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 活动示例业务实现
 * @author tanxw
 * @date 2020/6/3
 */
@Service
public class ActivityDemoServiceImpl extends BaseService<ActivityDemo> implements IActivityDemoService{

    @Autowired
    ActivityDemoMapper activityDemoMapper;

}
