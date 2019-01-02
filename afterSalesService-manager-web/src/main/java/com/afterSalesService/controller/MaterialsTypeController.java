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
import com.afterSalesService.pojo.MaterialsType;
import com.afterSalesService.service.IMaterialsTypeService;
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
 * @Description : 物料分类表  前端控制器 
 * ---------------------------------
 * @Author :  wjx
 * @Date : 2018-10-27
 */
@Controller
@RequestMapping("/materialsType")
@Api(value = "物料分类表接口", description = "物料分类表接口")
public class MaterialsTypeController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IMaterialsTypeService materialsTypeService;
	
	public IMaterialsTypeService getService() {
		return materialsTypeService;
	}
	
	/* 分页条件查询物料分类表  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", MaterialsType.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询物料分类表 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", MaterialsType.class);
		return super.queryList(modelMap, param);
	}

	/* 物料分类表详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody MaterialsType param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改物料分类表 */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", MaterialsType.class);
		return super.update(modelMap, param);
	}

	/* 删除物料分类表(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody MaterialsType param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}