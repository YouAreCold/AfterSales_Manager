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
import com.afterSalesService.pojo.Wsummary;
import com.afterSalesService.pojo.wsummary.bo.WsummaryBo;
import com.afterSalesService.service.IWsummaryService;
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
 * @Description : 工作总结  前端控制器 
 * ---------------------------------
 * @Author :  wjx
 * @Date : 2018-10-20
 */
@Controller
@RequestMapping("/wsummary")
@Api(value = "工作总结接口", description = "工作总结接口")
public class WsummaryController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IWsummaryService wsummaryService;
	
	public IWsummaryService getService() {
		return wsummaryService;
	}
	
	/* 分页条件查询工作总结  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", Wsummary.class);
		return super.queryPage(modelMap, param);
	}
	/* 查询工作总结表(关联工作计划表) 分页查询 */
	@RequestMapping(value = "/read/listPageAndPlant",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object listPageAndPlant(WsummaryBo wsummaryBo,@RequestParam Map<String, Object> param,ModelMap modelMap) {
		return super.ok(modelMap,wsummaryService.selectWsummaryListPage(wsummaryBo,param));
	}
	/* 未分页条件查询工作总结 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", Wsummary.class);
		return super.queryList(modelMap, param);
	}

	/* 工作总结详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody Wsummary param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改工作总结 */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", Wsummary.class);
		return super.update(modelMap, param);
	}

	/* 删除工作总结(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody Wsummary param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}