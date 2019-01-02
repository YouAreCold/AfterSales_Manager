package com.afterSalesService.sso.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;


/**
 * <p>
 *   dubbo服务暴露接口
 * </p>
 *
 * @author wjx
 * @since 2018-07-16
 */
public interface IUPermissionService  {

	// 查询单条
	public Object queryById(Long itemId);

	// 分页查询
	public Page queryPage(Map<String, Object> param);

	// 查询全部列表
	public List queryList(Map<String, Object> param);

	// 删除
	public void delete(Long itemId);

	// 增加与修改
	public Object update(Map<String, Object> param);
}