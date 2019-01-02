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
import com.afterSalesService.pojo.Materials;
import com.afterSalesService.pojo.materials.bo.MaterialsBo;
import com.afterSalesService.service.IMaterialsService;
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
 * @Description : 物料表  前端控制器 
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
@Controller
@RequestMapping("/materials")
@Api(value = "物料表接口", description = "物料表接口")
public class MaterialsController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IMaterialsService materialsService;
	
	public IMaterialsService getService() {
		return materialsService;
	}
	
	/* 查询物料表(关联单位与物料分类表) 分页查询 */
	@RequestMapping(value = "/read/listPageAndType",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object listPageAndType(MaterialsBo materialsBo,@RequestParam Map<String, Object> param,ModelMap modelMap) {
		return super.ok(modelMap,materialsService.selectMaterialsListPage(materialsBo,param));
	}
	
	/* 分页条件查询物料表  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", Materials.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询物料表 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", Materials.class);
		return super.queryList(modelMap, param);
	}

	/* 物料表详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody Materials param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改物料表 */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", Materials.class);
		return super.update(modelMap, param);
	}

	/* 删除物料表(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody Materials param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}