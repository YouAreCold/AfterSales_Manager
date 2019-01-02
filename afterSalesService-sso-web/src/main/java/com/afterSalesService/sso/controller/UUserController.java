package com.afterSalesService.sso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.common.utils.CookieUtils;
import com.afterSalesService.common.utils.JsonResult;
import com.afterSalesService.pojo.UUser;
import com.afterSalesService.sso.service.IUUserService;
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
 * @Description : 用户模块 前端控制器
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/uUser")
@Api(value = "接口", description = "接口")
public class UUserController extends AbstractController<BaseFacadeImpl> {
	
	//@Value("${TOKEN_KEY}")
	private String TOKEN_KEY="TT_TOKEN";
		
    @Reference
	private IUUserService uUserService;
	
	public IUUserService getService() {
		return uUserService;
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/read/listPage",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryPage(ModelMap modelMap,@RequestParam Map<String, Object> param) {
	    param.put("class", UUser.class);
		return super.queryPage(modelMap , param);
	}
	
	/**
	 * 查询全部
	 */
	@RequestMapping(value = "/read/list",method={RequestMethod.POST,RequestMethod.GET})
	public Object queryList(ModelMap modelMap, Map<String, Object> param) {
	    param.put("class", UUser.class);
		return super.queryList(modelMap, param);
	}
	
	/**
	 * 详情
	 */
	@ApiOperation(value = "详情")
	@PutMapping(value = "/read/detail")
	public Object get(ModelMap modelMap, @RequestBody UUser param) {
		return super.queryById(modelMap, param);
	}

	/**
	 * 增加与修改
	 */
	@PostMapping
	public Object update(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		param.put("class", UUser.class);
		return super.update(modelMap, param);
	}


	/* 删除用户(单条与多条) */
	@RequestMapping(value = "/read/delete",method={RequestMethod.POST,RequestMethod.GET})
	public Object delete(@RequestBody UUser param,ModelMap modelMap,@RequestParam("dels") String dels) {
		return super.delete(modelMap, param,dels);
	}
	
	/**
	 * 检查有无重复数据
	 */
	@RequestMapping(value = "/user/check/{param}/{type}", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonResult checkUserData(@PathVariable String param, @PathVariable Integer type) {
		JsonResult result = uUserService.checkData(param, type);
		return result;
	}
	
	/**
	 * 注册用户
	 */
	@RequestMapping(value="/user/register", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object regitster(ModelMap modelMap, @RequestBody UUser param) {
		JsonResult result = uUserService.register(param);
		return super.ok(modelMap, result);
	}
	
	/**
	 * 登录
	 */
	@RequestMapping(value="/user/login", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonResult login(@RequestParam("username") String username,@RequestParam("password") String password, 
			HttpServletResponse response, HttpServletRequest request) {
		JsonResult result = uUserService.login(username, password);
		//登录成功后写cookie
		if ("0".equals(result.getCode())) {
			//把token写入cookie
			CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
		}
		return result;
	}
	
	/**
	 * 检查token是否有效
	 * @return
	 */
	@RequestMapping(value="/user/token", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object getUserByToken(@RequestParam String token, String callback) {
		JsonResult result = uUserService.getUserByToken(token);
		//判断是否为jsonp请求
		if (StringUtils.isNotBlank(callback)) {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			//设置回调方法
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
		return result;
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value="/user/outLogin",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object outLogin(@RequestParam String token, String callback) {
		JsonResult result = uUserService.outLogin(token);
		return result;
	}
	
}