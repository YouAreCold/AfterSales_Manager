package com.afterSalesService.common.base.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.afterSalesService.common.constants.Constants;
import com.afterSalesService.common.entity.Parameter;
import com.afterSalesService.common.utils.ExceptionUtil;
import com.afterSalesService.common.utils.InstanceUtil;

@Component
public class BaseFacadeImpl implements BaseFacade {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Parameter execute(Parameter parameter) {
		String no = parameter.getNo();
		logger.info("{} 响应(request)：{}", no, JSON.toJSONString(parameter));
		Object service = parameter.getService();
		try {
			Long id = parameter.getId();
			Map<?, ?> map = parameter.getMap();
			String method = parameter.getMethod();
			Object result = null;
			if (id != null) {
				result = InstanceUtil.invokeMethod(service, method, id);
			} else if (map != null) {
				result = InstanceUtil.invokeMethod(service, method, map);
			} else {
				result = InstanceUtil.invokeMethod(service, method);
			}
			if (result != null) {
				Parameter response = new Parameter(result);
				logger.info("{} 响应(response)：{}", no, JSON.toJSONString(response));
				return response;
			}
			logger.info("{} 响应(response) empty.", no);
			return null;
		} catch (Exception e) {
			String msg = ExceptionUtil.getStackTrace(e);
			logger.error("发生异常 ["+no + " , " + Constants.Exception_Head + msg+"]", e);
			throw e;
		}
	}
}
