package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 投诉建议表
 * </p>
 *
 * @author wjx
 * @since 2018-11-04
 */
@SuppressWarnings("serial")
public class Complaint extends BaseModel {

	@TableField("f_sort_id")
	private Integer fSortId;
    /**
     * 作废
     */
    @ApiModelProperty(value = "作废")
	@TableField("f_cancel")
	private String fCancel;
    /**
     * 审核标识
     */
    @ApiModelProperty(value = "审核标识")
	@TableField("f_status")
	private Integer fStatus;
    /**
     * 选择
     */
    @ApiModelProperty(value = "选择")
	@TableField("f_sel")
	private String fSel;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
	@TableField("f_number")
	private Integer fNumber;
    /**
     * 老师代码
     */
    @ApiModelProperty(value = "老师代码")
	@TableField("f_teacher_number")
	private String fTeacherNumber;
    /**
     * 老师内码
     */
    @ApiModelProperty(value = "老师内码")
	@TableField("f_teacher_item_id")
	private Integer fTeacherItemId;
    /**
     * 老师名称
     */
    @ApiModelProperty(value = "老师名称")
	@TableField("f_teacher")
	private String fTeacher;
    /**
     * 老师电话
     */
    @ApiModelProperty(value = "老师电话")
	@TableField("f_teacher_phone")
	private String fTeacherPhone;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
	@TableField("f_client_name")
	private String fClientName;
    /**
     * 客户电话
     */
    @ApiModelProperty(value = "客户电话")
	@TableField("f_client_phone")
	private String fClientPhone;
    /**
     * 客户地址
     */
    @ApiModelProperty(value = "客户地址")
	@TableField("f_client_address")
	private String fClientAddress;
    /**
     * 投诉建议
     */
    @ApiModelProperty(value = "投诉建议")
	@TableField("f_words")
	private String fWords;
    /**
     * 业务员
     */
    @ApiModelProperty(value = "业务员")
	@TableField("f_clerk_name")
	private String fClerkName;
    /**
     * 批复意见
     */
    @ApiModelProperty(value = "批复意见")
	@TableField("f_reply")
	private String fReply;
    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
	@TableField("f_check")
	private String fCheck;
    /**
     * 审批日期
     */
    @ApiModelProperty(value = "审批日期")
	@TableField("f_check_date")
	private String fCheckDate;


	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

	public String getfCancel() {
		return fCancel;
	}

	public void setfCancel(String fCancel) {
		this.fCancel = fCancel;
	
	}

	public Integer getfStatus() {
		return fStatus;
	}

	public void setfStatus(Integer fStatus) {
		this.fStatus = fStatus;
	
	}

	public String getfSel() {
		return fSel;
	}

	public void setfSel(String fSel) {
		this.fSel = fSel;
	
	}

	public Integer getfNumber() {
		return fNumber;
	}

	public void setfNumber(Integer fNumber) {
		this.fNumber = fNumber;
	
	}

	public String getfTeacherNumber() {
		return fTeacherNumber;
	}

	public void setfTeacherNumber(String fTeacherNumber) {
		this.fTeacherNumber = fTeacherNumber;
	
	}

	public Integer getfTeacherItemId() {
		return fTeacherItemId;
	}

	public void setfTeacherItemId(Integer fTeacherItemId) {
		this.fTeacherItemId = fTeacherItemId;
	
	}

	public String getfTeacher() {
		return fTeacher;
	}

	public void setfTeacher(String fTeacher) {
		this.fTeacher = fTeacher;
		
	}

	public String getfTeacherPhone() {
		return fTeacherPhone;
	}

	public void setfTeacherPhone(String fTeacherPhone) {
		this.fTeacherPhone = fTeacherPhone;
	
	}

	public String getfClientName() {
		return fClientName;
	}

	public void setfClientName(String fClientName) {
		this.fClientName = fClientName;
	
	}

	public String getfClientPhone() {
		return fClientPhone;
	}

	public void setfClientPhone(String fClientPhone) {
		this.fClientPhone = fClientPhone;
	
	}

	public String getfClientAddress() {
		return fClientAddress;
	}

	public void setfClientAddress(String fClientAddress) {
		this.fClientAddress = fClientAddress;
	
	}

	public String getfWords() {
		return fWords;
	}

	public void setfWords(String fWords) {
		this.fWords = fWords;
	
	}

	public String getfClerkName() {
		return fClerkName;
	}

	public void setfClerkName(String fClerkName) {
		this.fClerkName = fClerkName;
	
	}

	public String getfReply() {
		return fReply;
	}

	public void setfReply(String fReply) {
		this.fReply = fReply;
	
	}

	public String getfCheck() {
		return fCheck;
	}

	public void setfCheck(String fCheck) {
		this.fCheck = fCheck;
	
	}

	public String getfCheckDate() {
		return fCheckDate;
	}

	public void setfCheckDate(String fCheckDate) {
		this.fCheckDate = fCheckDate;
	
	}

}