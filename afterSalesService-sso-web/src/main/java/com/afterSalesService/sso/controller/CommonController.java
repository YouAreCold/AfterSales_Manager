package com.afterSalesService.sso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
import com.afterSalesService.common.utils.DateUtil;
import com.afterSalesService.common.utils.FastDFSClient;
import com.afterSalesService.common.utils.JsonResult;
import com.afterSalesService.common.utils.ResultCode;
import com.afterSalesService.common.utils.VerifyCodeUtils;
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
 * @Description : 公共组件控制器Controller
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/common")
@Api(value = "接口", description = "接口")
public class CommonController extends AbstractController<BaseFacadeImpl> {
		
    @Reference
	private IUUserService uUserService;
	
	public IUUserService getService() {
		return uUserService;
	}

	/**
	 * 获取图片验证码
	 * @return
	 */
	@RequestMapping(value="/imageCode",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Object outLogin(@RequestParam String token) {
		logger.info("获取图片验证码..........start ["+DateUtil.getDateTime()+"]");
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		File dir = new File("F:/verifies");  
        int w = 200, h = 80;  
        File file = new File(dir, verifyCode + ".jpg");  
        try {
			VerifyCodeUtils.outputImage(w, h, file, verifyCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		FastDFSClient client = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		String uploadFile = client.uploadFile("F:/verifies/"+verifyCode+".jpg", "jpg");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("imagecode", verifyCode);
		jsonObject.put("imageUrl", "http://192.168.0.163:8088/" + uploadFile);
		logger.info("获取图片验证码完成..........end ["+DateUtil.getDateTime()+"]");
		return JsonResult.build(ResultCode.LOGIN_SUCCESS, "获取验证码成功！", jsonObject);
	}
	
}