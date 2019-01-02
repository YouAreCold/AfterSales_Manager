package com.afterSalesService.common.base.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.afterSalesService.common.utils.DateUtil;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 数据库操作基础实体
 * 
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel implements Serializable {
	
	@TableId(value = "id", type = IdType.INPUT)
	private Long id;

	@TableField("created") 	// 创建时间
	@ApiModelProperty(value = "创建时间")
	private String created;

	@TableField("updated") 	// 修改时间
	@ApiModelProperty(value = "修改时间")
	private String updated;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
