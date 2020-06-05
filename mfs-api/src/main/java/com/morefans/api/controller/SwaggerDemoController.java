package com.morefans.api.controller;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.morefans.activity.pojo.ActivityDemo;
import com.morefans.activity.request.vo.ActivityDemoBaseRequestVo;
import com.morefans.activity.request.vo.ActivityDemoBaseSearchVo;
import com.morefans.basic.core.base.ResponseResultManager;
import com.morefans.basic.core.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanxw
 * @date 2020/6/2
 */
@Api(description = "关于活动示例接口",value = "活动示例接口",tags = {"活动示例接口"})
@RestController
@RequestMapping("demo")
@AllArgsConstructor
@Slf4j
public class SwaggerDemoController {


    /**
     * 保存单个示例
     * @param
     * @return
     */
    @PostMapping("save")
    @ApiOperation(value = "保存活动示例",notes = "RestFul风格，需要传活动示例对象")
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
    @PutMapping("modify")
    @ApiOperation(value = "修改活动示例",notes = "RestFul风格，需要传活动示例对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "diamond",value = "活动示例个数",required = true),
            @ApiImplicitParam(name = "ticket",value = "活动示例票数",required = true),
            @ApiImplicitParam(name = "message",value = "活动示例信息",required = true),
    })
    public ResponseResult<String> updateDemo(@RequestBody ActivityDemoBaseRequestVo requestVo){
        log.info("更新活动示例，id为：{}",requestVo.getId());
//        activityDemoService.updateNotNull(requestVo);
        return ResponseResultManager.setResultMsgSuccess("更新成功");
    }


    /**
     * 删除单个活动示例
     * 一般都是逻辑删除，此处只做演示示例
     * @param
     * @return
     */
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除活动示例",notes = "RestFul风格，需要传活动示例Id")
    @ApiImplicitParam(name = "id",value = "活动示例Id",required = true)
    public ResponseResult<String> deleteDemo(@PathVariable("id") Long id){
        log.info("删除活动示例，id为：{}",id);
//        ActivityDemo activityDemo = activityDemoService.selectByKey(id);
//        activityDemoService.delete(activityDemo);
        return ResponseResultManager.setResultMsgSuccess("删除成功");
    }


    /**
     * 删除多个活动示例
     * 一般都是逻辑删除，此处只做演示示例
     * @param
     * @return
     */
    @DeleteMapping("delete/more")
    @ApiOperation(value = "删除多个活动示例",notes = "RestFul风格，需要传活动示例ids")
    @ApiImplicitParam(name = "ids",value = "活动示例ids",required = true)
    public ResponseResult<String> deleteDemo(@RequestParam String ids,@RequestParam(defaultValue = "1") Integer requestNumber){
        log.info("删除活动示例，id为：{}",ids);
//        String [] keys = ids.split(",");
//        if(keys.length > 20){
//            return ResponseResultManager.setResultError("删除数量过大...");
//        }
//        for ( String id: ids.split(",")) {
//
//        }
        return ResponseResultManager.setResultMsgSuccess("删除成功");
    }

    /**
     * 获取单个活动示例
     * @param
     * @return
     */
    @GetMapping("{id}")
    @ApiOperation(value = "获取单个活动示例",notes = "RestFul风格，需要传活动示例id")
    @ApiImplicitParam(name = "id",value = "活动示例id",required = true)
    public ResponseResult<ActivityDemo> getDemo(@PathVariable("id") Long id){
        log.info("获取活动示例，id为：{}",id);
//        ActivityDemo activityDemo = activityDemoService.selectByKey(id);
        ActivityDemo activityDemo = new ActivityDemo();
        activityDemo.setId(RandomUtil.randomLong());
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
    @GetMapping("list")
    @ApiOperation(value = "获取活动示例列表",notes = "RestFul风格，需要传查询条件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginTicket",value = "开始票数",required = false),
            @ApiImplicitParam(name = "endTicket",value = "结束票数",required = false),
            @ApiImplicitParam(name = "message",value = "信息",required = false)
    })
    public ResponseResult<PageInfo<ActivityDemo>> listDemo(@RequestParam ActivityDemoBaseSearchVo searchVo){
        List<ActivityDemo> activityDemoList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            ActivityDemo activityDemo = new ActivityDemo();
            activityDemo.setId(RandomUtil.randomLong());
            activityDemo.setDiamond(RandomUtil.randomInt(1000,100000));
            activityDemo.setTicket(RandomUtil.randomInt(1000,100000));
            activityDemo.setMessage("今天卖出去多少张票？");
            activityDemoList.add(activityDemo);
        }
        PageHelper.startPage(1,10,true);
        PageInfo<ActivityDemo> pageInfo = new PageInfo<>(activityDemoList);
        return ResponseResultManager.setResultSuccess(pageInfo);
    }

}
