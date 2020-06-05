package com.morefans.activity.service.impl;

import com.morefans.activity.mapper.ActivityDemoMapper;
import com.morefans.activity.pojo.ActivityDemo;
import com.morefans.activity.service.ActivityDemoService;
import com.morefans.common.mybatis.common.service.impl.BaseService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 活动示例业务实现
 * @author tanxw
 * @date 2020/6/3
 */
@Service
public class ActivityDemoServiceImpl extends BaseService<ActivityDemo> implements ActivityDemoService {

    @Autowired
    ActivityDemoMapper activityDemoMapper;

}
