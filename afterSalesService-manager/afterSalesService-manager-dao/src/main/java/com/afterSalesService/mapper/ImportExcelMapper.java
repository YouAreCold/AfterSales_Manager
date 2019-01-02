package com.afterSalesService.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
public interface ImportExcelMapper {
	
	
	// 导入Excel 添加
	@Insert({"${sql}"})
	int importExcelInsert(@Param("sql") String sql);
	
	// 导入Excel 更新
	@Update({"${sql}"})
	int importExcelUpdate(@Param("sql") String sql);
		
}