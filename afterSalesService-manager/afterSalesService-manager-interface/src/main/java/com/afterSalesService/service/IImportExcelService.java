package com.afterSalesService.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
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
public interface IImportExcelService  {

	// 导入Excel
	int importExcelInsert(String sql);
	// 导入Excel
	int importExcelUpdate(String sql);
		
}