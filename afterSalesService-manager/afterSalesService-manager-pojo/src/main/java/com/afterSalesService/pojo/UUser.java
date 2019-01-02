package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import com.afterSalesService.common.base.pojo.BaseModel;
import com.afterSalesService.common.utils.DateUtil;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 
 * </p>
 *
 * @author wjx
 * @since 2018-08-05
 */
@TableName("u_user")
@SuppressWarnings("serial")
public class UUser extends BaseModel {
	
	
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
	@TableField("nickname")
	private String nickname;
    /**
     * 邮箱|登录帐号
     */
    @ApiModelProperty(value = "邮箱|登录帐号")
	@TableField("email")
	private String email;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
	@TableField("pswd")
	private String pswd;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
	@TableField("phone")
	private String phone;
    
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
	@TableField("last_login_time")
	private String lastLoginTime;
    /**
     * 1:有效，0:禁止登录
     */
    @ApiModelProperty(value = "1:有效，0:禁止登录")
	@TableField("status")
	private Long status;

	/**
	 * 用户头像地址
	 */
	@ApiModelProperty(value = "用户头像地址")
	@TableField("image_url")
	private String imageUrl;

	public UUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UUser(UUser user) {
		super();
		this.nickname = user.nickname;
		this.email = user.email;
		this.pswd = user.pswd;
		this.lastLoginTime = user.lastLoginTime;
		this.status = user.status;
		this.phone = user.phone;
		this.imageUrl = user.imageUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "UUser [nickname=" + nickname + ", email=" + email + ", pswd="
				+ pswd + ", phone=" + phone + ", lastLoginTime="
				+ lastLoginTime + ", status=" + status + "]"+", imagUrl=" + imageUrl + "]";
	}
	
}