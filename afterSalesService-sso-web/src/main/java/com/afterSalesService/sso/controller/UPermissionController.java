package com.afterSalesService.sso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.pojo.UPermission;
import com.afterSalesService.sso.service.IUPermissionService;
import com.alibaba.dubbo.config.annotation.Reference;


/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description : 前端控制器
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
@Controller
@RequestMapping("/uPermission")
@Api(value = "接口", description = "接口")
public class UPermissionController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IUPermissionService uPermissionService;
	
	public IUPermissionService getService() {
		return uPermissionService;
	}
	
	@ApiOperation(value = "分页条件查询")
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap, @RequestBody Map<String, Object> param) {
	    param.put("class", UPermission.class);
		return super.queryPage(modelMap, param);
	}
	
	@ApiOperation(value = "未分页条件查询")
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, @RequestBody Map<String, Object> param) {
	    param.put("class", UPermission.class);
		return super.queryList(modelMap, param);
	}

	@ApiOperation(value = "详情")
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody UPermission param) {
		return super.queryById(modelMap, param);
	}

	@PostMapping
	@ApiOperation(value = "增加与修改")
	public Object update(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		param.put("class", UPermission.class);
		return super.update(modelMap, param);
	}

	@DeleteMapping
	@ApiOperation(value = "删除")
	public Object delete(ModelMap modelMap, @RequestBody UPermission param,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}