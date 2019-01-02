package com.afterSalesService.pojo;

import io.swagger.annotations.ApiModelProperty;

import com.afterSalesService.common.base.pojo.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;



/**
 * <p>
 * 客户表
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class Organization extends BaseModel {

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
	@TableField("f_number")
	private String fNumber;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
	@TableField("f_name")
	private String fName;
    /**
     * 专营业务员名称
     */
    @ApiModelProperty(value = "专营业务员名称")
	@TableField("f_employee_name")
	private String fEmployeeName;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
	@TableField("f_address")
	private String fAddress;
   
    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
	@TableField("f_email")
	private String fEmail;
    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行")
	@TableField("f_bank")
	private String fBank;
    /**
     * 银行账号
     */
    @ApiModelProperty(value = "银行账号")
	@TableField("f_account")
	private String fAccount;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
	@TableField("f_sex")
	private String fSex;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
	@TableField("f_phone")
	private String fPhone;
    /**
     * 区域
     */
    @ApiModelProperty(value = "区域")
	@TableField("f_area")
	private String fArea;
   
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
	@TableField("f_short_name")
	private String fShortName;
    
    /**
     * 当前状态  0 无  1 预约  2  忽略  3 推迟
     */
    @ApiModelProperty(value = "当前状态  0 无  1 预约  2  忽略  3 推迟")
	@TableField("f_status")
	private int fStatus;
    
    /**
     * 部门(内码)
     */
    @ApiModelProperty(value = "部门(内码)")
	@TableField("f_dept_id")
	private long fDeptId;
    
    /**
     * 禁用标志  0 禁用  1  启用
     */
    @ApiModelProperty(value = "禁用标志  0 禁用  1  启用")
	@TableField("f_deleted")
	private String fDeleted;
    
	@TableField("f_sort_id")
	private Integer fSortId;

	
	public int getfStatus() {
		return fStatus;
	}

	public void setfStatus(int fStatus) {
		this.fStatus = fStatus;
	}

	public String getfNumber() {
		return fNumber;
	}

	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfEmployeeName() {
		return fEmployeeName;
	}

	public void setfEmployeeName(String fEmployeeName) {
		this.fEmployeeName = fEmployeeName;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public String getfBank() {
		return fBank;
	}

	public void setfBank(String fBank) {
		this.fBank = fBank;
	}

	public String getfAccount() {
		return fAccount;
	}

	public void setfAccount(String fAccount) {
		this.fAccount = fAccount;
	}

	public String getfSex() {
		return fSex;
	}

	public void setfSex(String fSex) {
		this.fSex = fSex;
	}

	public String getfPhone() {
		return fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}

	public String getfArea() {
		return fArea;
	}

	public void setfArea(String fArea) {
		this.fArea = fArea;
	}

	public String getfShortName() {
		return fShortName;
	}

	public void setfShortName(String fShortName) {
		this.fShortName = fShortName;
	}

	public long getfDeptId() {
		return fDeptId;
	}

	public void setfDeptId(long fDeptId) {
		this.fDeptId = fDeptId;
	}

	public String getfDeleted() {
		return fDeleted;
	}

	public void setfDeleted(String fDeleted) {
		this.fDeleted = fDeleted;
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	}

}