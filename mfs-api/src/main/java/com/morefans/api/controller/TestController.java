package com.morefans.api.controller;

import com.morefans.activity.dubbo.service.ActivityDemoDubboService;
import com.morefans.activity.response.vo.ActivityDemoBaseResponseVo;
import com.morefans.basic.core.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanxw
 * @date 2020/6/3
 */
@RestController
@RequestMapping("api/v1")
@Slf4j
public class TestController {

    @Reference(check = false)
    private ActivityDemoDubboService activityDemoDubboService;

    @GetMapping("activity/demo/{id}")
    public ResponseResult<ActivityDemoBaseResponseVo> getDemobyId(@PathVariable Long id){
        return activityDemoDubboService.getDemobyId(id);
    }
}

