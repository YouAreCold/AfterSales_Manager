package com.afterSalesService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afterSalesService.common.base.mapper.BaseMapper;
import com.afterSalesService.pojo.Materials;
import com.afterSalesService.pojo.materials.bo.MaterialsBo;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
public interface MaterialsMapper extends BaseMapper<Materials> {
	// 查询物料表(关联单位与物料分类表) 分页查询
	List<MaterialsBo> selectMaterialsListPage(Pagination page ,@Param("materialsBo") MaterialsBo materialsBo);

}