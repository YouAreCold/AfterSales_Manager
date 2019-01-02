package com.afterSalesService.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.pojo.materials.bo.MaterialsBo;
import com.baomidou.mybatisplus.plugins.Page;


/**
 * <p>
 * 物料表  dubbo服务暴露接口
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
public interface IMaterialsService  {

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
	
	// 查询物料表(关联单位与物料分类表)
	List<MaterialsBo> selectMaterialsListPage(MaterialsBo materialsBo,@RequestParam Map<String, Object> param);
}