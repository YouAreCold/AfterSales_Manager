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
@TableName("u_role_permission")
@SuppressWarnings("serial")
public class URolePermission extends BaseModel {
	
	
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
	@TableField("rid")
	private Long rid;
    /**
     * 权限ID
     */
    @ApiModelProperty(value = "权限ID")
	@TableField("pid")
	private Long pid;


	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}