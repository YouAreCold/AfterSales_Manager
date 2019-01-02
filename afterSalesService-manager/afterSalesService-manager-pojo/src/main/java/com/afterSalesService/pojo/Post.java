package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 职位表
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class Post extends BaseModel {
	
	

    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
	@TableField("f_number")
	private String fNumber;
    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
	@TableField("f_name")
	private String fName;
    /**
     * 职级
     */
    @ApiModelProperty(value = "职级")
	@TableField("f_level")
	private String fLevel;
    
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

	public String getfLevel() {
		return fLevel;
	}

	public void setfLevel(String fLevel) {
		this.fLevel = fLevel;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}