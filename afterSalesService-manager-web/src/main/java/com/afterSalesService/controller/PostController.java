package com.afterSalesService.controller;

import io.swagger.annotations.Api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.pojo.Post;
import com.afterSalesService.service.IPostService;
import com.alibaba.dubbo.config.annotation.Reference;


/**
 * <p>
 * 职位表  前端控制器
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
@Controller
@RequestMapping("/post")
@Api(value = "职位表接口", description = "职位表接口")
public class PostController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IPostService postService;
	
	public IPostService getService() {
		return postService;
	}
	
	/* 分页条件查询职位表  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", Post.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询职位表 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", Post.class);
		return super.queryList(modelMap, param);
	}

	/* 职位表详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody Post param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改职位表 */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", Post.class);
		return super.update(modelMap, param);
	}

	/* 删除职位表(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody Post param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}