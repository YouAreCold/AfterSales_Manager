package com.afterSalesService.common.base.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.baomidou.mybatisplus.plugins.Page;
import com.afterSalesService.common.base.pojo.BaseModel;
import com.afterSalesService.common.entity.Parameter;
import com.afterSalesService.common.utils.DateUtil;

/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description : 控制器基类
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
public abstract class AbstractController<T extends BaseFacade> extends BaseController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected T provider;

	public abstract Object getService();

	public Object queryPage(ModelMap modelMap, Map<String, Object> param) {
		Parameter parameter = new Parameter(getService(), "queryPage").setMap(param);
		logger.info("{} 开始分页查询数据   start...["+DateUtil.getDateTime()+"]", parameter.getNo());
		Page<?> list = provider.execute(parameter).getPage();
		logger.info("{} 完成分页查询数据 end... ["+DateUtil.getDateTime()+"]", parameter.getNo());
		return setSuccessModelMap(modelMap, list);
	}

	public Object update(ModelMap modelMap, Map<String, Object> param) {
		Parameter parameter = new Parameter(getService(), "update").setMap(param);
		logger.info("{} 开始执行更新或新增操作 start...["+DateUtil.getDateTime()+"]", parameter.getNo());
		Object result = provider.execute(parameter).getResult();
		logger.info("{} 完成更新或新增操作   end...["+DateUtil.getDateTime()+"]", parameter.getNo());
		return setSuccessModelMap(modelMap, result);
	}

	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
		Parameter parameter = new Parameter(getService(), "queryList").setMap(param);
		logger.info("{} 开始执行查询全部数据    start...["+DateUtil.getDateTime()+"]", parameter.getNo());
		List<?> list = provider.execute(parameter).getList();
		logger.info("{} 完成查询全部数据     end...["+DateUtil.getDateTime()+"]", parameter.getNo());
		return setSuccessModelMap(modelMap, list);
	}

	public Object queryById(ModelMap modelMap, BaseModel param) {
		Parameter parameter = new Parameter(getService(), "queryById").setId(param.getId());
		logger.info("{} 开始执行查询单条数据    start...["+DateUtil.getDateTime()+"]", parameter.getNo());
		Object result = null;
		if (null != provider.execute(parameter)) {
			result = provider.execute(parameter).getResult();
		}
		logger.info("{} 完成查询单条数据     end...["+DateUtil.getDateTime()+"]", parameter.getNo());
		return setSuccessModelMap(modelMap, result);
	}

	public Object delete(ModelMap modelMap, BaseModel param,String del) {
		String userId = getCurrUser();
		// 判断删除多条或者单条
		if("-1".equals(del)||"".equals(del)||del==null){
			Parameter parameter = new Parameter(getService(), "delete").setId(param.getId());
			logger.info("{} execute delete start...["+DateUtil.getDateTime()+"]", parameter.getNo());
			provider.execute(parameter);
			logger.info("{} execute delete end...["+DateUtil.getDateTime()+"]", parameter.getNo());
		}else{
			String[] idsArrayStrings = del.split(",");
			for (int i = 0; i < idsArrayStrings.length; i++) {
				Parameter parameter = new Parameter(getService(), "delete").setId(Long.parseLong(idsArrayStrings[i]));
				logger.info("{} execute deletes start...["+DateUtil.getDateTime()+"]", parameter.getNo());
				provider.execute(parameter);
				logger.info("{} execute deletes end...["+DateUtil.getDateTime()+"]", parameter.getNo());
			}
		}
		return setSuccessModelMap(modelMap);
	}
	
	public Object upload(ModelMap modelMap, Map<String, Object> param) {
		logger.info("{} 完成上传操作  end...["+DateUtil.getDateTime()+"]",param);
		return setSuccessModelMap(modelMap,param);
	}
	
	public Object ImprotExcel(ModelMap modelMap, Map<String, Object> param) {
		logger.info("{} 完成导入Excel操作  end...["+DateUtil.getDateTime()+"]",param);
		return setSuccessModelMap(modelMap,param);
	}
	
	public Object ok(ModelMap modelMap, Object param) {
		logger.info("{} 完成CRUD操作  end...["+DateUtil.getDateTime()+"]",param);
		return setSuccessModelMap(modelMap,param);
	}
}
