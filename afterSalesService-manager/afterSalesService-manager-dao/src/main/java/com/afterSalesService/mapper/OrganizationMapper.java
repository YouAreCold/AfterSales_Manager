package com.afterSalesService.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.afterSalesService.common.base.mapper.BaseMapper;
import com.afterSalesService.pojo.Organization;
import com.afterSalesService.pojo.organization.bo.OrganizationBo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
public interface OrganizationMapper extends BaseMapper<Organization> {
	
	// 客户表关联部门表 分页查询
	List<OrganizationBo> selectOrganizationListPage(Pagination page ,@Param("organizationBo") OrganizationBo organizationBo);
	
	// 客户表关联部门表 提醒模块   分页查询
	List<OrganizationBo> selectOrganizationListPageAndReminder(Pagination page ,@Param("organizationBo") OrganizationBo organizationBo);
	
	
}