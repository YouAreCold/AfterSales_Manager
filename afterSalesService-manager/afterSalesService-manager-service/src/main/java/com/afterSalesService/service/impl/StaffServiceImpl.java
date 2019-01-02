package com.afterSalesService.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.afterSalesService.common.base.service.BaseService;
import com.afterSalesService.pojo.Staff;
import com.afterSalesService.service.IStaffService;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 职员表  接口实现类
 * </p>
 *
 * @author wjx
 * @param <Staff>
 * @since 2018-08-05
 */
@Component
@Service(interfaceName = "com.afterSalesService.service.IStaffService")
public class StaffServiceImpl extends BaseService<Staff> implements IStaffService{

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
}