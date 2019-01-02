package com.afterSalesService.sso.service.impl;

import io.swagger.annotations.Info;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javassist.expr.NewArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import com.afterSalesService.common.base.service.BaseService;
import com.afterSalesService.common.utils.DateUtil;
import com.afterSalesService.common.utils.JavaBeanUtil;
import com.afterSalesService.common.utils.JsonResult;
import com.afterSalesService.common.utils.JsonUtils;
import com.afterSalesService.common.utils.ResultCode;
import com.afterSalesService.jedis.JedisClient;
import com.afterSalesService.pojo.UUser;
import com.afterSalesService.sso.service.IUUserService;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *   接口实现类
 * </p>
 *
 * @author wjx
 * @param <UUUser>
 * @since 2018-07-16
 */
@Component
@Service(interfaceName = "com.afterSalesService.sso.service.IUUserService")
public class UUserServiceImpl extends BaseService<UUser> implements IUUserService{
	//@Value("${USER_SESSION}")
	private String USER_SESSION="USER_SESSION";
	//@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE=1800;
	// 输入日志
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JedisClient jedisClient;
	// 查询单条
	public Object queryById(Long id) {
		return super.queryById(id);
	}

	// 分页查询
	public Page queryPage(Map<String, Object> param) {
		return super.queryPage(param);
	}
	
	// 查询全部列表
	public List queryList(Map<String, Object> param) {
		return super.queryList(param);
	}

	// 删除
	public void delete(Long id) {
		super.delete(id);
	}
	
	// 增加与修改
	public Object update(Map<String, Object> param) {
		return super.update(param);
	}
	
	// 检查数据是否合法
	@Override
	public JsonResult checkData(String data, int type) {
		logger.info("{} 开始检验数据  start ["+DateUtil.getDateTime()+"]",data);
		// 查询条件
		Map<String, String[]> whereParam = new HashMap<String, String[]>();
		
		//设置查询条件
		//1.判断用户名是否可用
		if (type == 1) {
			whereParam.put("nickname", new String[]{"1",data,"2"});
			logger.info("{} 开始检验数据nickname有无重复    ["+DateUtil.getDateTime()+"]",data);
		//2判断手机号是否可以使用
		} else if (type == 2) {
			whereParam.put("phone", new String[]{"1",data,"2"});
			logger.info("{} 开始检验数据phone有无重复    ["+DateUtil.getDateTime()+"]",data);
		//3判断邮箱是否可以使用
		} else if (type == 3) {
			whereParam.put("email", new String[]{"1","'"+data+"'","2"});
			logger.info("{} 开始检验数据email有无重复    ["+DateUtil.getDateTime()+"]",data);
		} else {
			logger.info("{} 检验到无此类型    ["+DateUtil.getDateTime()+"]",data);
			return JsonResult.build(ResultCode.FORMAT, "参数中包含非法数据（相同）");
		}
		//执行查询
		List<UUser> UUserList = super.queryListToData(UUser.class, whereParam);
		if (UUserList !=null && UUserList.size() > 0) {
			logger.info("{} 此参数检验完成(有重复的数据)  end ["+DateUtil.getDateTime()+"]",data);
			//查询到数据，返回false
			return JsonResult.ok(false);
		}
		logger.info("{} 此参数检验完成  end ["+DateUtil.getDateTime()+"]",data);
		//数据可以使用
		return JsonResult.ok(true);
	}
	
	// 注册
	@Override
	public JsonResult register(UUser uUser) {
		logger.info("正在进行注册验证["+uUser+"]...start==>"+DateUtil.getDateTime());
		//检查数据的有效性
		if (StringUtils.isBlank(uUser.getNickname())) {
			return JsonResult.build(ResultCode.FORMAT, "用户名不能为空");
		}
		//判断用户名是否重复
		JsonResult JsonResult = checkData(uUser.getNickname(), 1);
		logger.info("检查结果==>"+JsonResult);
		if (!(boolean) JsonResult.getData()) {
			return JsonResult.build(ResultCode.FORMAT, "用户名重复");
		}
		//判断密码是否为空
		if (StringUtils.isBlank(uUser.getPswd())) {
			return JsonResult.build(ResultCode.FORMAT, "密码不能为空");
		}
		if (StringUtils.isNotBlank(uUser.getPhone())) {
			//是否重复校验
			JsonResult = checkData(uUser.getPhone(), 2);
			if (!(boolean) JsonResult.getData()) {
				return JsonResult.build(ResultCode.FORMAT, "电话号码重复");
			}
		}
		//如果email不为空的话进行是否重复校验
		if (StringUtils.isNotBlank(uUser.getEmail())) {
			//是否重复校验
			JsonResult = checkData(uUser.getEmail(), 3);
			if (!(boolean) JsonResult.getData()) {
				return JsonResult.build(ResultCode.FORMAT, "Email重复");
			}
		}
		String time = DateUtil.getDateTime();//获取当前时间
		uUser.setCreated(time);
		uUser.setUpdated(time);
		uUser.setLastLoginTime(time);
		//密码要进行md5加密
		String md5Pass = DigestUtils.md5DigestAsHex(uUser.getPswd().getBytes());
		uUser.setPswd(md5Pass);
		logger.info("正在进行注册验证完成，开始注册....["+DateUtil.getDateTime()+"]");
		Map<String, Object> map = JavaBeanUtil.convertBeanToMap(uUser);
		map.put("class", UUser.class);
		//插入数据
		super.update(map);
		logger.info("注册完成["+DateUtil.getDateTime()+"]");
		//返回注册成功
		return JsonResult.ok(true);
	}

	// 登录验证
	@Override
	public JsonResult login(String UUsername, String password) {
		logger.info("正在进行登录验证["+UUsername+","+password+"]...start");
		// 查询条件
		Map<String, String[]> whereParam = new HashMap<String, String[]>();
		whereParam.put("nickname", new String[]{"1",UUsername,"2"});
		//判断用户名和密码是否正确value = "'" + value + "'";
		List<UUser> UUserList = super.queryListToData(UUser.class, whereParam);
		if (UUserList == null || UUserList.size() == 0) {
			//返回登录失败
			return JsonResult.build(ResultCode.LOGIN_ERROR, "找不到此用户，请注册！");
		}
		UUser uUser = UUserList.get(0);
		//密码要进行md5加密然后再校验
		if (!DigestUtils.md5DigestAsHex(password.getBytes())
				.equals(uUser.getPswd())) {
			//返回登录失败
			return JsonResult.build(ResultCode.LOGIN_ERROR, "用户名或密码不正确!");
		}
		//生成token，使用uuid
		String token = UUID.randomUUID().toString();
		//清空密码,密码为个人隐私
		uUser.setPswd(null);
		//把用户信息保存到redis，key就是token，value就是用户信息
		jedisClient.set(USER_SESSION + ":" + token, JSONObject.fromObject(uUser).toString());
		//设置key的过期时间
		jedisClient.expire(USER_SESSION + ":" + token, SESSION_EXPIRE);
		logger.info("登录验证完成...end");
		//返回登录成功，其中要把token返回.
		JSONObject jsonData = new JSONObject();
		jsonData.put("access_token", token);
		return JsonResult.build(ResultCode.LOGIN_SUCCESS,ResultCode.LOGIN_SUCCESS.msg(),jsonData);
	}

	// 获取当前token有无过期
	@Override
	public JsonResult getUserByToken(String token) {
		String json = jedisClient.get(USER_SESSION + ":" + token);
		if (StringUtils.isBlank(json)) {
			return JsonResult.build(ResultCode.FORMAT, "用户登录已经过期");
		}
		//重置Session的过期时间
		jedisClient.expire(USER_SESSION + ":" + token, SESSION_EXPIRE);
		//把json转换成UUser对象
		//UUser UUser = JsonUtils.jsonToPojo(json, UUser.class);
		return JsonResult.ok(JSONObject.fromObject(json));
	}
	
	// 退出登录
	@Override
	public JsonResult outLogin(String token) {
		logger.info("退出登录(清除redis)......start ["+DateUtil.dateToStringWithTime()+"]");
		Long delId = jedisClient.del(USER_SESSION + ":" + token);
		logger.info("退出是否成功==>"+delId);
		//重置Session的过期时间
		jedisClient.expire(USER_SESSION + ":" + token, SESSION_EXPIRE);
		//把json转换成UUser对象
		//UUser UUser = JsonUtils.jsonToPojo(json, UUser.class);
		logger.info("退出登录完成(清除redis)......end ["+DateUtil.dateToStringWithTime()+"]");
		return JsonResult.build(ResultCode.LOGIN_SUCCESS, "退出成功！");
	}
	public void test(){
		//jedisClient.
	}
	public static void main(String[] args) {
		UUserServiceImpl uUserServiceImpl = new UUserServiceImpl();
		uUserServiceImpl.test();
	}
}