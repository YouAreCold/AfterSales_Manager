package com.afterSalesService.controller;

import io.swagger.annotations.Api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.afterSalesService.common.base.controller.AbstractController;
import com.afterSalesService.common.base.controller.BaseFacadeImpl;
import com.afterSalesService.common.utils.FastDFSClient;
import com.afterSalesService.common.utils.poi.ReadExcel;
import com.afterSalesService.service.IImportExcelService;
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
 * @Description : 公共组件Controller
 * ---------------------------------
 * @Author : Kris.wjx
 * @Date :
 */
@Controller
@RequestMapping("/comm")
@Api(value = "公共接口", description = "公共接口")
public class CommController  extends AbstractController<BaseFacadeImpl>{

	@Reference
	private IImportExcelService iImportExcelService;
	
	public IImportExcelService getiImportExcelService() {
		return iImportExcelService;
	}
	
	@Override
	public Object getService() {
		// TODO Auto-generated method stub
		return null;
	}
   
	/* 上传图片  通过本地路径上传 */
	@RequestMapping(value = "/upload/imageString", method = {RequestMethod.POST})
	public Object uploadImageString(ModelMap modelMap,@RequestParam Map<String, Object> param) {
		FastDFSClient client = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		String uploadFile = client.uploadFile(param.get("path").toString(), param.get("pathType").toString());
		param.put("src", "http://192.168.0.163:8088/" + uploadFile);
		return super.upload(modelMap,param);
	}
	
	/* 上传图片 通过MultipartFile上传 */
	 @RequestMapping(value = "/upload/image", method = {RequestMethod.POST})
     public Object uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request,ModelMap modelMap) throws IllegalStateException, IOException{
		 //获取文件名,设置中文乱码
         String filename = file.getOriginalFilename();
         // 创建FastDFS客户端
		 FastDFSClient client = new FastDFSClient("F:/开发/afterSalesService/afterSalesService-manager-web/src/main/resources/resource/client.conf");
		 String path = client.uploadFile(file.getBytes(), filename.substring(filename.lastIndexOf(".") + 1));
		 Map<String, Object> param = new HashMap<String, Object>();
		 modelMap.put("src", "http://192.168.0.163:8088/" + path);
		 return super.upload(modelMap,param);
     }
	 	/**
		 * 导入Excel
		 * @param file
		 * @return 
		 * @throws Exception
		 */
		@RequestMapping(value = "/importexcel", method = {RequestMethod.GET,RequestMethod.POST})
		public Object importexcel(@RequestParam("file") MultipartFile file) throws Exception {
			//创建处理EXCEL的类  
			ReadExcel readExcel = new ReadExcel();  
			//解析excel，获取上传的事件单  
			List<String> excelList = readExcel.getExcelInfo(file);
			// 批量导入 执行sql
			for (String string : excelList) {
				iImportExcelService.importExcelInsert(string);
			}
			return super.ImprotExcel(null,null);
		}
}
