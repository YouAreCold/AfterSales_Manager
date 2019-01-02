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
@TableName("u_user_role")
@SuppressWarnings("serial")
public class UUserRole extends BaseModel {
	

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
	@TableField("uid")
	private Long uid;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
	@TableField("rid")
	private Long rid;


	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

}