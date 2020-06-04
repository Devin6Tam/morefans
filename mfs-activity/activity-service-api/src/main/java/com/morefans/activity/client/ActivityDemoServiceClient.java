package com.morefans.activity.client;


import com.morefans.activity.constant.ActivityServiceNameConstant;
import com.morefans.activity.entity.ActivityDemo;
import com.morefans.activity.request.vo.ActivityDemoBaseRequestVo;
import com.morefans.activity.request.vo.ActivityDemoBaseSearchVo;
import com.morefans.basic.core.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 活动示例服务远程调用客户端
 *
 * @author tanxw
 */
@FeignClient(ActivityServiceNameConstant.ACTIVITY_SERVICE)
public interface ActivityDemoServiceClient {

	/**
	 * 保存单个示例
	 * @param
	 * @return
	 */
	@PostMapping("/demo/save")
	ResponseResult<Object> saveDemo(@RequestBody ActivityDemoBaseRequestVo requestVo);

	/**
	 * 修改单个活动示例
	 * @param
	 * @return
	 */
	@GetMapping("/demo/update")
	ResponseResult<Object> updateDemo(@RequestBody ActivityDemoBaseRequestVo requestVo);


	/**
	 * 删除单个活动示例
	 * @param
	 * @return
	 */
	@PutMapping("/demo/delete/{id}")
	ResponseResult<String> deleteDemo(@PathVariable("id") Long id);


	/**
	 * 删除多个活动示例
	 * @param
	 * @return
	 */
	@DeleteMapping("/demo/delete/more")
	ResponseResult<Object> deleteDemo(@RequestParam(name = "ids",required = true) String ids);

	/**
	 * 获取单个活动示例
	 * @param
	 * @return
	 */
	@GetMapping("/demo/{id}")
	ResponseResult<Object> getDemo(@PathVariable("id") Long id);


	/**
	 * 活动示例列表
	 * @param
	 * @return
	 */
	@GetMapping("/demo/list")
	ResponseResult<Object> listDemo(ActivityDemoBaseSearchVo searchVo);
}
