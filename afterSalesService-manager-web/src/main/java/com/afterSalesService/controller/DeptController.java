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
import org.springframework.web.bind.annotation.ResponseBody;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.pojo.Dept;
import com.afterSalesService.pojo.organization.bo.OrganizationBo;
import com.afterSalesService.service.IDeptService;
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
 * @Description : 部门表  前端控制器
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
@Controller
@RequestMapping("/dept")
@Api(value = "部门表接口", description = "部门表接口")
public class DeptController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IDeptService deptService;
	
	public IDeptService getService() {
		return deptService;
	}
	
	/* 分页条件查询部门表  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", Dept.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询部门表 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", Dept.class);
		return super.queryList(modelMap, param);
	}
	
	/*下拉框 查询全部 带排序*/
	@RequestMapping(value = "/read/selectAll")
	@ResponseBody
	public Object selectAll(ModelMap modelMap,@RequestParam("id") String id) {
		return super.ok(modelMap,deptService.selectAll(id));
	}
	
	/* 部门表详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody Dept param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改部门表 */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", Dept.class);
		return super.update(modelMap, param);
	}

	/* 删除部门表(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody Dept param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}