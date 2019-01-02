package com.afterSalesService.pojo;

import io.swagger.annotations.ApiModelProperty;

import com.afterSalesService.common.base.pojo.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;



/**
 * <p>
 * 物料分类表
 * </p>
 *
 * @author wjx
 * @since 2018-10-27
 */
@SuppressWarnings("serial")
public class MaterialsType extends BaseModel {

    /**
     * 物料类型名称
     */
    @ApiModelProperty(value = "物料类型名称")
	@TableField("materials_type_name")
	private String materialsTypeName;


	public String getMaterialsTypeName() {
		return materialsTypeName;
	}

	public void setMaterialsTypeName(String materialsTypeName) {
		this.materialsTypeName = materialsTypeName;
		
	}

}