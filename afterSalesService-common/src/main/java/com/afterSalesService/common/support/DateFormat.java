package com.afterSalesService.common.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.afterSalesService.common.utils.DateUtil;

/**
 * 时间格式化扩展
 * 
 */
@SuppressWarnings("serial")
public class DateFormat extends SimpleDateFormat {

	public Date parse(String source) throws ParseException {
		return DateUtil.stringToDate(source);
	}
}
