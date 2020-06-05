package com.morefans.api.controller;

import com.morefans.activity.dubbo.service.ActivityDemoDubboService;
import com.morefans.activity.response.vo.ActivityDemoBaseResponseVo;
import com.morefans.basic.core.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "关于测试示例接口",value = "测试示例接口",tags = {"测试示例接口"})
@RestController
@RequestMapping("api/v1")
@Slf4j
public class TestController {

    @Reference(check = false)
    private ActivityDemoDubboService activityDemoDubboService;

    @GetMapping("activity/demo/{id}")
    @ApiOperation(value = "获取单个测试示例",notes = "RestFul风格，需要传测试示例id")
    @ApiImplicitParam(name = "id",value = "测试示例id",required = true)
    public ResponseResult<ActivityDemoBaseResponseVo> getDemobyId(@PathVariable Long id){
        return activityDemoDubboService.getDemobyId(id);
    }
}

