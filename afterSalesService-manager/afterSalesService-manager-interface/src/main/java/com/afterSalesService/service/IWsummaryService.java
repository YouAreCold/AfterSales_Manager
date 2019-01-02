package com.afterSalesService.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.pojo.materials.bo.MaterialsBo;
import com.afterSalesService.pojo.wsummary.bo.WsummaryBo;
import com.baomidou.mybatisplus.plugins.Page;


/**
 * <p>
 * 工作总结  dubbo服务暴露接口
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
public interface IWsummaryService  {

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
	
	// 查询工作总结表(关联工作计划表)
	List<WsummaryBo> selectWsummaryListPage(WsummaryBo wsummaryBo,@RequestParam Map<String, Object> param);
}