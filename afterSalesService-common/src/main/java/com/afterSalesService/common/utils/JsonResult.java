package com.afterSalesService.common.utils;

import java.io.Serializable;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 统一返回结果
 * @author wjx
 *
 */
public class JsonResult implements Serializable{
	private String code;	// 状态码
    private String message;	// 消息
    private Object data;	// 数据
    
    private static final long serialVersionUID = -6878053406541100993L;

    /**
     * 一系列构造方法
     */
    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");
    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }
    
    public JsonResult(Object data) {
        this.setData(data);
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }
    public JsonResult(ResultCode code, String message,Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }
    
    /**
     *  默认成功
     */
    public static JsonResult ok(){
    	return new JsonResult();
    }
    
    /**
     * 自定义返回结果1
     */
    public static JsonResult build(ResultCode code, String message){
    	return new JsonResult(code,message);
    }
    
    /**
     * 自定义返回结果2
     */
    public static JsonResult build(ResultCode code, String message,Object data){
    	return new JsonResult(code,message,data);
    }
    
    /**
     * 根据布尔值判断对错返回
     */
    public static JsonResult ok(Object data){
    	if(data instanceof Boolean){
    		if((boolean)data){
    			return new JsonResult(ResultCode.SUCCESS,ResultCode.SUCCESS.msg(),data);
    		}else{
    			return new JsonResult(ResultCode.RERROR,ResultCode.RERROR.msg(),data);
    		}
    	}
    	return new JsonResult(ResultCode.SUCCESS,ResultCode.SUCCESS.msg(),data);
    }

    /**
     * 默认返回模板
     */
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("code", code);
            json.put("msg", message);
            json.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

