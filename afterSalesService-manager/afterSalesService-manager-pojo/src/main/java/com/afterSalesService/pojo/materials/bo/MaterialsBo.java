package com.afterSalesService.pojo.materials.bo;

import com.baomidou.mybatisplus.annotations.TableField;

import java.math.BigDecimal;

import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 物料表
 * </p>
 *
 * @author wjx
 * @since 2018-08-09
 */
@SuppressWarnings("serial")
public class MaterialsBo extends BaseModel {
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
	@TableField("f_number")
	private String fNumber;
    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
	@TableField("f_brand")
	private String fBrand;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
	@TableField("f_name")
	private String fName;
    /**
     * 型号
     */
    @ApiModelProperty(value = "型号")
	@TableField("f_model")
	private String fModel;
    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
	@TableField("f_alias")
	private String fAlias;
    /**
     * 颜色
     */
    @ApiModelProperty(value = "颜色")
	@TableField("f_chart_number")
	private String fChartNumber;
    /**
     * 商品条码
     */
    @ApiModelProperty(value = "商品条码")
	@TableField("f_help_code")
	private String fHelpCode;
    /**
     * 物料分类号
     */
    @ApiModelProperty(value = "物料分类号")
	@TableField("f_good_spec")
	private String fGoodSpec;
    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
	@TableField("f_equipment_num")
	private String fEquipmentNum;
    /**
     * 销售单价
     */
    @ApiModelProperty(value = "销售单价")
	@TableField("f_sale_price")
	private BigDecimal fSalePrice;
    /**
     * 单位内码
     */
    @ApiModelProperty(value = "单位内码")
	@TableField("f_unit_id")
	private String fUnitId;
    /**
     * 类别
     */
    @ApiModelProperty(value = "类别")
	@TableField("f_type")
	private String fType;
    
	@TableField("f_sort_id")
	private Integer fSortId;
    
    /**
     * 物料类别名称
     */
    @ApiModelProperty(value = "物料类别名称")
	@TableField("materials_type_name")
	private String materialsTypeName;
    
    /**
     * 物料类别ID
     */
    @ApiModelProperty(value = "物料类别ID")
	@TableField("f_type")
	private String materialsTypeID;
    
    
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
	@TableField("f_unit_name")
	private String unitName;
	
	public String getMaterialsTypeID() {
		return materialsTypeID;
	}

	public void setMaterialsTypeID(String materialsTypeID) {
		this.materialsTypeID = materialsTypeID;
	}

	public String getMaterialsTypeName() {
		return materialsTypeName;
	}

	public void setMaterialsTypeName(String materialsTypeName) {
		this.materialsTypeName = materialsTypeName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getfNumber() {
		return fNumber;
	}

	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	public String getfBrand() {
		return fBrand;
	}

	public void setfBrand(String fBrand) {
		this.fBrand = fBrand;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfModel() {
		return fModel;
	}

	public void setfModel(String fModel) {
		this.fModel = fModel;
	}

	public String getfAlias() {
		return fAlias;
	}

	public void setfAlias(String fAlias) {
		this.fAlias = fAlias;
	}

	public String getfChartNumber() {
		return fChartNumber;
	}

	public void setfChartNumber(String fChartNumber) {
		this.fChartNumber = fChartNumber;
	}

	public String getfHelpCode() {
		return fHelpCode;
	}

	public void setfHelpCode(String fHelpCode) {
		this.fHelpCode = fHelpCode;
	}

	public String getfGoodSpec() {
		return fGoodSpec;
	}

	public void setfGoodSpec(String fGoodSpec) {
		this.fGoodSpec = fGoodSpec;
	}

	public String getfEquipmentNum() {
		return fEquipmentNum;
	}

	public void setfEquipmentNum(String fEquipmentNum) {
		this.fEquipmentNum = fEquipmentNum;
	}

	public BigDecimal getfSalePrice() {
		return fSalePrice;
	}

	public void setfSalePrice(BigDecimal fSalePrice) {
		this.fSalePrice = fSalePrice;
	}

	public String getfUnitId() {
		return fUnitId;
	}

	public void setfUnitId(String fUnitId) {
		this.fUnitId = fUnitId;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	}

}