package com.morefans.api.controller;

import com.morefans.activity.client.ActivityDemoServiceClient;
import com.morefans.activity.request.vo.ActivityDemoBaseRequestVo;
import com.morefans.basic.core.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanxw
 * @date 2020/6/3
 */
@RestController
@AllArgsConstructor
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
    @PutMapping("/demo/update")
    public ResponseResult<Object> updateDemo(@RequestBody ActivityDemoBaseRequestVo requestVo){
        log.info("获取活动示例，id为：{}",requestVo.getId());
        return activityDemoServiceClient.updateDemo(requestVo);
    }
}

