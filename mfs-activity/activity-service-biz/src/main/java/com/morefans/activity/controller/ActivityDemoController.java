package com.morefans.activity.controller;

import cn.hutool.core.util.RandomUtil;
import com.morefans.activity.entity.ActivityDemo;
import com.morefans.activity.request.vo.ActivityDemoBaseRequestVo;
import com.morefans.activity.request.vo.ActivityDemoBaseSearchVo;
import com.morefans.basic.core.base.BaseController;
import com.morefans.basic.core.base.ResponseResultManager;
import com.morefans.basic.core.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanxw
 * @date 2020/6/2
 */
@Api(description = "关于活动示例接口",value = "活动示例接口",tags = {"活动示例接口"})
@RestController
@AllArgsConstructor
public class ActivityDemoController implements BaseController{


    /**
     * 保存单个示例
     * @param
     * @return
     */
    @PostMapping("demo/save")
    @ApiOperation(value = "保存用户信息",notes = "RestFul风格，需要传活动示例对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "diamond",value = "活动示例个数",required = true),
            @ApiImplicitParam(name = "ticket",value = "活动示例票数",required = true),
            @ApiImplicitParam(name = "message",value = "活动示例信息",required = true),
    })
    public ResponseResult<String> saveDemo(@RequestBody ActivityDemoBaseRequestVo requestVo){
        return ResponseResultManager.setResultMsgSuccess("保存成功");
    }

    /**
     * 修改单个活动示例
     * @param
     * @return
     */
    @PutMapping("demo/modify/{id}")
    @ApiOperation(value = "修改活动示例",notes = "RestFul风格，需要传活动示例Id")
    @ApiImplicitParam(name = "id",value = "活动示例Id",required = true)
    public ResponseResult<String> updateDemo(@PathVariable("id") Long id){
        logger.info("更新活动示例，id为：{}",id);
        return ResponseResultManager.setResultMsgSuccess("更新成功");
    }


    /**
     * 删除单个活动示例
     * @param
     * @return
     */
    @DeleteMapping("demo/delete/{id}")
    @ApiOperation(value = "删除活动示例",notes = "RestFul风格，需要传活动示例Id")
    @ApiImplicitParam(name = "id",value = "活动示例Id",required = true)
    public ResponseResult<String> deleteDemo(@PathVariable("id") Long id){
        logger.info("删除活动示例，id为：{}",id);
        return ResponseResultManager.setResultMsgSuccess("删除成功");
    }


    /**
     * 删除多个活动示例
     * @param
     * @return
     */
    @DeleteMapping("demo/delete/more")
    @ApiOperation(value = "删除多个活动示例",notes = "RestFul风格，需要传活动示例ids")
    @ApiImplicitParam(name = "ids",value = "活动示例ids",required = true)
    public ResponseResult<String> deleteDemo(@RequestParam String ids){
        logger.info("删除活动示例，id为：{}",ids);
        return ResponseResultManager.setResultMsgSuccess("删除成功");
    }

    /**
     * 获取单个活动示例
     * @param
     * @return
     */
    @GetMapping("demo/{id}")
    @ApiOperation(value = "获取单个活动示例",notes = "RestFul风格，需要传活动示例id")
    @ApiImplicitParam(name = "id",value = "活动示例id",required = true)
    public ResponseResult<ActivityDemo> getDemo(@PathVariable("id") Long id){
        logger.info("获取活动示例，id为：{}",id);
        ActivityDemo activityDemo = new ActivityDemo();

        activityDemo.setId(id);
        activityDemo.setDiamond(RandomUtil.randomInt(1000,100000));
        activityDemo.setTicket(RandomUtil.randomInt(1000,100000));
        activityDemo.setMessage("今天卖出去多少张票？");
        return ResponseResultManager.setResultSuccess(activityDemo);
    }


    /**
     * 活动示例列表
     * @param
     * @return
     */
    @GetMapping("demo/list")
    @ApiOperation(value = "获取活动示例列表",notes = "RestFul风格，需要传查询条件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginTicket",value = "开始票数",required = false),
            @ApiImplicitParam(name = "endTicket",value = "结束票数",required = false),
            @ApiImplicitParam(name = "message",value = "信息",required = false)
    })
    public ResponseResult<List<ActivityDemo>> listDemo(@RequestParam ActivityDemoBaseSearchVo searchVo){

        List<ActivityDemo> activityDemoList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            ActivityDemo activityDemo = new ActivityDemo();
            activityDemo.setId(RandomUtil.randomLong());
            activityDemo.setDiamond(RandomUtil.randomInt(1000,100000));
            activityDemo.setTicket(RandomUtil.randomInt(1000,100000));
            activityDemo.setMessage("今天卖出去多少张票？");
            activityDemoList.add(activityDemo);
        }
        return ResponseResultManager.setResultSuccess(activityDemoList);
    }

}