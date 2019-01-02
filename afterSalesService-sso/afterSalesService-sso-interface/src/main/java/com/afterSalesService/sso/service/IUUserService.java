package com.afterSalesService.sso.service;

import java.util.List;
import java.util.Map;

import com.afterSalesService.common.utils.JsonResult;
import com.afterSalesService.pojo.UUser;
import com.baomidou.mybatisplus.plugins.Page;


/**
 * <p>
 *   dubbo服务暴露接口
 * </p>
 *
 * @author wjx
 * @since 2018-07-16
 */
public interface IUUserService  {

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
	
	// 检查数据
	JsonResult checkData(String data, int type);
	
	// 注册
	JsonResult register(UUser user);
	
	// 登录
	JsonResult login(String username, String password);
	
	// 获取token
	JsonResult getUserByToken(String token);
	
	// 退出登录
	JsonResult outLogin(String token);
}