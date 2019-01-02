package com.afterSalesService.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.pojo.SysMenu;
import com.afterSalesService.service.ISysMenuService;
import com.alibaba.dubbo.config.annotation.Reference;


/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author wjx
 * @since 2018-08-06
 */
@Controller
@RequestMapping("/sysMenu")
@Api(value = "接口", description = "接口")
public class SysMenuController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private ISysMenuService sysMenuService;
	
	public ISysMenuService getService() {
		return sysMenuService;
	}
	
	/* 分页条件查询  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap, @RequestBody Map<String, Object> param) {
	    param.put("class", SysMenu.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, @RequestBody Map<String, Object> param) {
	    param.put("class", SysMenu.class);
		return super.queryList(modelMap, param);
	}

	/* 详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody SysMenu param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改 */
	@PostMapping
	public Object update(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		param.put("class", SysMenu.class);
		return super.update(modelMap, param);
	}

	/* 删除职员表(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(ModelMap modelMap, @RequestBody SysMenu param,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}