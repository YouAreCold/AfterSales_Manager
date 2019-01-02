package com.afterSalesService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.common.base.service.BaseService;
import com.afterSalesService.mapper.OrganizationMapper;
import com.afterSalesService.pojo.Organization;
import com.afterSalesService.pojo.organization.bo.OrganizationBo;
import com.afterSalesService.service.IOrganizationService;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 客户表  接口实现类
 * </p>
 *
 * @author wjx
 * @param <Organization>
 * @since 2018-08-05
 */
@Component
@Service(interfaceName = "com.afterSalesService.service.IOrganizationService")
public class OrganizationServiceImpl extends BaseService<Organization> implements IOrganizationService{
	@Autowired
	OrganizationMapper organizationMapper;

	// 查询单条
	public Object queryById(Long id) {
		return super.queryById(id);
	}

	// 分页查询
	public Page queryPage(Map<String, Object> param) {
		return super.queryPage(param);
	}
	
	// 查询全部列表
	public List queryList(Map<String, Object> param) {
		return super.queryList(param);
	}

	// 删除
	public void delete(Long id) {
		super.delete(id);
	}
	
	// 增加与修改
	public Object update(Map<String, Object> param) {
		return super.update(param);
	}
	
	@Transactional(readOnly=true)
	public Page<OrganizationBo> selectOrganizationListPage(OrganizationBo organizationbo,@RequestParam Map<String, Object> param) {
		Page<OrganizationBo> pages = new Page<OrganizationBo>(1,10);
		// 判断记录数
		if (param.get("limit").toString() != null && Integer.valueOf(param.get("limit").toString()) > 0) pages.setSize((Integer.valueOf(param.get("limit").toString())));
		else pages.setSize(10);
		// 判断页数
		if (param.get("page").toString()!=null && Integer.valueOf(param.get("page").toString()) > 0) pages.setCurrent((Integer.valueOf(param.get("page").toString())));
		else pages.setCurrent(1);
		
		return pages.setRecords(organizationMapper.selectOrganizationListPage(pages , organizationbo));
	}
	
	@Transactional(readOnly=true)
	public Page<OrganizationBo> selectOrganizationListPageAndReminder(OrganizationBo organizationbo,@RequestParam Map<String, Object> param) {
		Page<OrganizationBo> pages = new Page<OrganizationBo>(1,10);
		// 判断记录数
		if (param.get("limit").toString() != null && Integer.valueOf(param.get("limit").toString()) > 0) pages.setSize((Integer.valueOf(param.get("limit").toString())));
		else pages.setSize(10);
		// 判断页数
		if (param.get("page").toString()!=null && Integer.valueOf(param.get("page").toString()) > 0) pages.setCurrent((Integer.valueOf(param.get("page").toString())));
		else pages.setCurrent(1);
		
		return pages.setRecords(organizationMapper.selectOrganizationListPageAndReminder(pages , organizationbo));
	}
	
}