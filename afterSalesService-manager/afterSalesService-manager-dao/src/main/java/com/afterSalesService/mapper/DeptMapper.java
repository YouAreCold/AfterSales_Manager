package com.afterSalesService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afterSalesService.common.base.mapper.BaseMapper;
import com.afterSalesService.pojo.Dept;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
public interface DeptMapper extends BaseMapper<Dept> {
	// 部门 查询全部
	List<Dept> selectAll(@Param("id") String id);

}