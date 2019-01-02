package com.afterSalesService.common.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class Test {
	/**
	 * 转换class
	 * @param param
	 * @return
	 */
	private static Object mapToBean(Map<String, Object> param) {
		Object obj = null;
		try {
			obj = ((Class<?>) param.get("class")).newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		ConvertUtils.register(new Converter() {
			@SuppressWarnings("rawtypes")
			public Object convert(Class arg0, Object arg1) {
				if (arg1 == null) {
					return null;
				}
				if (!(arg1 instanceof String)||!(arg1 instanceof Date)) {
					throw new ConversionException("只支持字符串转换 !");
				}
				String str = (String) arg1;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					return sd.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}

		}, java.util.Date.class);
		try {
			BeanUtils.populate(obj, param);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("class", "class com.afterSalesService.pojo.Unit");
		mapToBean(map);
	}
	
}
