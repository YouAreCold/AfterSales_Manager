package com.afterSalesService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afterSalesService.mapper.ImportExcelMapper;
import com.afterSalesService.service.IImportExcelService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * 物料表  接口实现类
 * </p>
 *
 * @author wjx
 * @param <Materials>
 * @since 2018-08-05
 */
@Component
@Service(interfaceName = "com.afterSalesService.service.IImportExcelService")
public class ImportExcelServiceImpl implements IImportExcelService{
	@Autowired
	ImportExcelMapper importExcelMapper;

	@Override
	public int importExcelInsert(String sql) {
		return importExcelMapper.importExcelInsert(sql);
	}

	@Override
	public int importExcelUpdate(String sql) {
		// TODO Auto-generated method stub
		return importExcelMapper.importExcelUpdate(sql);
	}

	
}