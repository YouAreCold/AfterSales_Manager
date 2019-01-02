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
import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.pojo.Picture;
import com.afterSalesService.service.IPictureService;
import com.alibaba.dubbo.config.annotation.Reference;


/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
@Controller
@RequestMapping("/picture")
@Api(value = "接口", description = "接口")
public class PictureController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IPictureService pictureService;
	
	public IPictureService getService() {
		return pictureService;
	}
	
	@ApiOperation(value = "分页条件查询")
	@PutMapping(value = "/read/listPage")
	public Object queryPage(ModelMap modelMap, @RequestBody Map<String, Object> param) {
	    param.put("class", Picture.class);
		return super.queryPage(modelMap, param);
	}
	
	@ApiOperation(value = "未分页条件查询")
	@PutMapping(value = "/read/list")
	public Object queryList(ModelMap modelMap, @RequestBody Map<String, Object> param) {
	    param.put("class", Picture.class);
		return super.queryList(modelMap, param);
	}

	@ApiOperation(value = "详情")
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody Picture param) {
		return super.queryById(modelMap, param);
	}

	@PostMapping
	@ApiOperation(value = "增加与修改")
	public Object update(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		param.put("class", Picture.class);
		return super.update(modelMap, param);
	}

	@DeleteMapping
	@ApiOperation(value = "删除")
	public Object delete(ModelMap modelMap, @RequestBody Picture param,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}