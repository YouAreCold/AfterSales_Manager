package com.afterSalesService.common.utils;

/**
 * 状态码枚举
 * @author wjx
 *
 */
public enum ResultCode {
	 /** 成功 */
    SUCCESS("200", "成功"),

    /** 操作失败 */
    FAIL("205", "操作失败"),
    
    /** 格式错误 */
    FORMAT("400", "格式错误"),
    
    /** 未知错误*/
    RERROR("999", "未知错误"),

    /** 数据已存在 */
    SUCCESS_IS_HAVE("208", "数据已存在"),

    /** 没有结果 */
    NOT_DATA("911", "没有结果"),

    /** 没有登录 */
    NOT_LOGIN("600", "没有登录"),

    /** 发生异常 */
    EXCEPTION("401", "发生异常"),

    /** 系统错误 */
    SYS_ERROR("402", "系统错误"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误 "),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED("410", "不支持或已经废弃"),

    /** AuthCode错误 */
    INVALID_AUTHCODE("444", "无效的AuthCode"),

    /** 太频繁的调用 */
    TOO_FREQUENT("445", "太频繁的调用"),

    /** 未知的错误 */
    UNKNOWN_ERROR("499", "未知错误"),

    /** 未设置方法 */
    NOT_METHOD("4004", "未设置方法"),
    
    /** 登录成功码 */
    LOGIN_SUCCESS("0", "登录成功"),
    
    /** 登录失败码 */
    LOGIN_ERROR("1001", "登录失败");

    private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
