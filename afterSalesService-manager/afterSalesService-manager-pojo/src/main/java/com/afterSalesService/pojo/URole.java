package com.afterSalesService.pojo;

import io.swagger.annotations.ApiModelProperty;

import com.afterSalesService.common.base.pojo.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * <p>
 * 
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
@TableName("u_role")
@SuppressWarnings("serial")
public class URole extends BaseModel {
	
	
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
	@TableField("name")
	private String name;
    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
	@TableField("type")
	private String type;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}