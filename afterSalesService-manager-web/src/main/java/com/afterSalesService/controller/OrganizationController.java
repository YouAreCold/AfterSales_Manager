package com.afterSalesService.controller;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.common.utils.poi.ReadExcel;
import com.afterSalesService.pojo.Organization;
import com.afterSalesService.pojo.organization.bo.OrganizationBo;
import com.afterSalesService.service.IImportExcelService;
import com.afterSalesService.service.IOrganizationService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;


/**
 * 客户表  前端控制器
 *
 * @author wjx
 * @since 2018-08-05
 */
@Controller
@RequestMapping("/organization")
@Api(value = "客户表接口", description = "客户表接口")
public class OrganizationController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IOrganizationService organizationService;
	
	public IOrganizationService getService() {
		return organizationService;
	}
	
	
	/* 查询客户表与部门表关联(带分页) */
	@RequestMapping(value = "/read/listPageAndDept",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object listPageAndDept(OrganizationBo organizationBo,@RequestParam Map<String, Object> param,ModelMap modelMap) {
		return super.ok(modelMap,organizationService.selectOrganizationListPage(organizationBo,param));
	}
	
	
	/* 查询客户表与客户表关联(带分页) 提醒模块 */
	@RequestMapping(value = "/read/listPageAndReminder",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object listPageAndReminder(OrganizationBo organizationBo,@RequestParam Map<String, Object> param,ModelMap modelMap) {
		return super.ok(modelMap,organizationService.selectOrganizationListPageAndReminder(organizationBo,param));
	}
	
	/* 分页条件查询客户表  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", Organization.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询客户表 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", Organization.class);
		return super.queryList(modelMap, param);
	}

	/* 客户表详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody Organization param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改客户表 */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", Organization.class);
		return super.update(modelMap, param);
	}

	/* 删除客户表(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody Organization param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
	
	
	
}