package com.afterSalesService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.afterSalesService.common.base.mapper.BaseMapper;
import com.afterSalesService.pojo.Wsummary;
import com.afterSalesService.pojo.wsummary.bo.WsummaryBo;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
public interface WsummaryMapper extends BaseMapper<Wsummary> {
	// 查询工作总结表(关联工作计划表)
	List<WsummaryBo> selectWsummaryListPage(Pagination page ,@Param("wsummaryBo") WsummaryBo wsummaryBo);
	
}