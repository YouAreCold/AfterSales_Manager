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
@TableName("u_permission")
@SuppressWarnings("serial")
public class UPermission extends BaseModel {
	
    /**
     * url地址
     */
    @ApiModelProperty(value = "url地址")
	@TableField("url")
	private String url;
    /**
     * url描述
     */
    @ApiModelProperty(value = "url描述")
	@TableField("name")
	private String name;


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}