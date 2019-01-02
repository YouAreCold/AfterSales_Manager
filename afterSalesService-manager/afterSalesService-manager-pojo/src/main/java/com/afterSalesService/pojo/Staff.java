package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 职员表
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class Staff extends BaseModel {
	
	

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
	@TableField("f_number")
	private String fNumber;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
	@TableField("f_name")
	private String fName;
    /**
     * 职员类别
     */
    @ApiModelProperty(value = "职员类别")
	@TableField("f_emp_group")
	private String fEmpGroup;
    /**
     * 部门内码
     */
    @ApiModelProperty(value = "部门内码")
	@TableField("f_dept_id")
	private String fDeptId;
    /**
     * 性别  1 男  2 女  0 未知
     */
    @ApiModelProperty(value = "性别  1 男  2 女  0 未知")
	@TableField("f_sex")
	private String fSex;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
	@TableField("f_birthday")
	private String fBirthday;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
	@TableField("f_phone")
	private String fPhone;
    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码")
	@TableField("f_id")
	private String fId;
    /**
     * 职务内码
     */
    @ApiModelProperty(value = "职务内码")
	@TableField("f_duty_id")
	private String fDutyId;
    /**
     * 禁用标志
     */
    @ApiModelProperty(value = "禁用标志")
	@TableField("f_deleted")
	private String fDeleted;
    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
	@TableField("f_hire_date")
	private String fHireDate;
    /**
     * 离职时间
     */
    @ApiModelProperty(value = "离职时间")
	@TableField("f_leave_date")
	private String fLeaveDate;
    /**
     * 开户银行及账号
     */
    @ApiModelProperty(value = "开户银行及账号")
	@TableField("f_bank_account")
	private String fBankAccount;
    /**
     * 住址
     */
    @ApiModelProperty(value = "住址")
	@TableField("f_address")
	private String fAddress;
    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
	@TableField("f_email")
	private String fEmail;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
	@TableField("f_remarks")
	private String fRemarks;
    
	@TableField("f_sort_id")
	private Integer fSortId;


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

	public String getfEmpGroup() {
		return fEmpGroup;
	}

	public void setfEmpGroup(String fEmpGroup) {
		this.fEmpGroup = fEmpGroup;
	
	}

	public String getfDeptId() {
		return fDeptId;
	}

	public void setfDeptId(String fDeptId) {
		this.fDeptId = fDeptId;
	
	}

	public String getfSex() {
		return fSex;
	}

	public void setfSex(String fSex) {
		this.fSex = fSex;
	
	}

	public String getfBirthday() {
		return fBirthday;
	}

	public void setfBirthday(String fBirthday) {
		this.fBirthday = fBirthday;
	
	}

	public String getfPhone() {
		return fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	
	}

	public String getfDutyId() {
		return fDutyId;
	}

	public void setfDutyId(String fDutyId) {
		this.fDutyId = fDutyId;
	
	}

	public String getfDeleted() {
		return fDeleted;
	}

	public void setfDeleted(String fDeleted) {
		this.fDeleted = fDeleted;
	
	}

	public String getfHireDate() {
		return fHireDate;
	}

	public void setfHireDate(String fHireDate) {
		this.fHireDate = fHireDate;
	
	}

	public String getfLeaveDate() {
		return fLeaveDate;
	}

	public void setfLeaveDate(String fLeaveDate) {
		this.fLeaveDate = fLeaveDate;
	
	}

	public String getfBankAccount() {
		return fBankAccount;
	}

	public void setfBankAccount(String fBankAccount) {
		this.fBankAccount = fBankAccount;
	
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

	public String getfRemarks() {
		return fRemarks;
	}

	public void setfRemarks(String fRemarks) {
		this.fRemarks = fRemarks;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}