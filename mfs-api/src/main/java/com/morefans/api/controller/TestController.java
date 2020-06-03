package com.morefans.api.controller;

import com.morefans.activity.client.ActivityDemoServiceClient;
import com.morefans.activity.entity.ActivityDemo;
import com.morefans.activity.request.vo.ActivityDemoBaseRequestVo;
import com.morefans.basic.core.base.BaseController;
import com.morefans.basic.core.base.ResponseResultManager;
import com.morefans.basic.core.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanxw
 * @date 2020/6/3
 */
@RestController
@AllArgsConstructor
@RequestMapping("activity")
@Slf4j
public class TestController{


    private final ActivityDemoServiceClient activityDemoServiceClient;


    /**
     * 获取单个活动示例
     * @param
     * @return
     */
    @GetMapping("/demo/{id}")
    public ResponseResult<Object> getDemo(@PathVariable("id") Long id){
        log.info("获取活动示例，id为：{}",id);
        return activityDemoServiceClient.getDemo(id);
    }


    /**
     * 更新活动示例
     * @param
     * @return
     */
    @GetMapping("/demo/update")
    public ResponseResult<Object> updateDemo(@RequestBody ActivityDemoBaseRequestVo requestVo){
        log.info("获取活动示例，id为：{}",requestVo.getId());
        return activityDemoServiceClient.updateDemo(requestVo);
    }
}

