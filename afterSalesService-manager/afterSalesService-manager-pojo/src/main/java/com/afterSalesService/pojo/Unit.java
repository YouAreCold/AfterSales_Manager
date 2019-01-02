package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 单位表
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class Unit extends BaseModel {
	
	
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
	@TableField("f_number")
	private String fNumber;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
	@TableField("f_unit_name")
	private String fUnitName;
    
	@TableField("f_sort_id")
	private Integer fSortId;


	public String getfNumber() {
		return fNumber;
	}

	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	public String getfUnitName() {
		return fUnitName;
	}

	public void setfUnitName(String fUnitName) {
		this.fUnitName = fUnitName;
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	}

}