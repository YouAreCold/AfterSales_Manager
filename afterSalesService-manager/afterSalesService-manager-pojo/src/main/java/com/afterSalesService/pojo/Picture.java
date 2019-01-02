package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class Picture extends BaseModel {
	


    /**
     * 图片URL地址
     */
    @ApiModelProperty(value = "图片URL地址")
	@TableField("img_url")
	private String imgUrl;
    /**
     * 图片类型  1 jpg  2 png
     */
    @ApiModelProperty(value = "图片类型  1 jpg  2 png")
	@TableField("img_type")
	private Integer imgType;


	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getImgType() {
		return imgType;
	}

	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	
	}

}