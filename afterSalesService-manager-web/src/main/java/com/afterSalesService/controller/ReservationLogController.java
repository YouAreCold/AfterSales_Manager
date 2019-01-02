package com.afterSalesService.controller;

import io.swagger.annotations.Api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.pojo.ReservationLog;
import com.afterSalesService.service.IReservationLogService;
import com.alibaba.dubbo.config.annotation.Reference;


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
 * @Description : 预约记录(关联预约表)  前端控制器 
 * ---------------------------------
 * @Author :  wjx
 * @Date : 2018-10-20
 */
@Controller
@RequestMapping("/reservationLog")
@Api(value = "预约记录(关联预约表)接口", description = "预约记录(关联预约表)接口")
public class ReservationLogController extends AbstractController<BaseFacadeImpl> {
    @Reference
	private IReservationLogService reservationLogService;
	
	public IReservationLogService getService() {
		return reservationLogService;
	}
	
	/* 分页条件查询预约记录(关联预约表)  */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", ReservationLog.class);
		return super.queryPage(modelMap, param);
	}
	
	/* 未分页条件查询预约记录(关联预约表) */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", ReservationLog.class);
		return super.queryList(modelMap, param);
	}

	/* 预约记录(关联预约表)详情  */
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody ReservationLog param) {
		return super.queryById(modelMap, param);
	}

	/* 增加与修改预约记录(关联预约表) */
	@PostMapping
	public Object update(@RequestBody Map<String, Object> param,ModelMap modelMap) {
		param.put("class", ReservationLog.class);
		return super.update(modelMap, param);
	}

	/* 删除预约记录(关联预约表)(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody ReservationLog param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
}