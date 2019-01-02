package com.afterSalesService.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.common.base.service.BaseService;
import com.afterSalesService.mapper.DeptMapper;
import com.afterSalesService.pojo.Dept;
import com.afterSalesService.service.IDeptService;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 部门表  接口实现类
 * </p>
 *
 * @author wjx
 * @param <Dept>
 * @since 2018-08-05
 */
@Component
@Service(interfaceName = "com.afterSalesService.service.IDeptService")
public class DeptServiceImpl extends BaseService<Dept> implements IDeptService{
	
	@Autowired
	private DeptMapper deptMapper;
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

	@Override
	public List<Dept> selectAll(@RequestParam("id") String id) {
		return deptMapper.selectAll(id);
	}
}