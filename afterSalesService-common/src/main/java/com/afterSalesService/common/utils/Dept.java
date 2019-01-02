package com.afterSalesService.common.utils;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 部门表
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class Dept extends BaseModel {

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
     * 主管
     */
    @ApiModelProperty(value = "主管")
	@TableField("f_manager_name")
	private String fManagerName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
	@TableField("f_remarks")
	private String fRemarks;
    /**
     * 禁用标志 0 禁用  1 启用
     */
    @ApiModelProperty(value = "禁用标志 0 禁用  1 启用")
	@TableField("f_deleted")
	private String fDeleted;
	@TableField("f_sort_id")
	private Integer fSortId;


	public String getfNumber() {
		return fNumber;
	}

	public Dept setfNumber(String fNumber) {
		this.fNumber = fNumber;
	return this;
	}

	public String getfName() {
		return fName;
	}

	public Dept setfName(String fName) {
		this.fName = fName;
	return this;
	}

	public String getfManagerName() {
		return fManagerName;
	}

	public Dept setfManagerName(String fManagerName) {
		this.fManagerName = fManagerName;
		return this;
	}

	public String getfRemarks() {
		return fRemarks;
	}

	public Dept setfRemarks(String fRemarks) {
		this.fRemarks = fRemarks;
		return this;
	}

	public String getfDeleted() {
		return fDeleted;
	}

	public Dept setfDeleted(String fDeleted) {
		this.fDeleted = fDeleted;
		return this;
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public Dept setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
		return this;
	}

}