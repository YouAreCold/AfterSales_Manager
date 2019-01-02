package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 预约模快
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
@SuppressWarnings("serial")
public class Reservation extends BaseModel {

    /**
     * 单号
     */
    @ApiModelProperty(value = "单号")
	@TableField("f_order_sn")
	private String fOrderSn;
    /**
     * 产品代码
     */
    @ApiModelProperty(value = "产品代码")
	@TableField("f_order_itemnumber")
	private String fOrderItemnumber;
    /**
     * 产品品牌
     */
    @ApiModelProperty(value = "产品品牌")
	@TableField("f_order_itemnote")
	private String fOrderItemnote;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
	@TableField("f_order_itemname")
	private String fOrderItemname;
    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
	@TableField("f_order_itemmodel")
	private String fOrderItemmodel;
    /**
     * 产品规格
     */
    @ApiModelProperty(value = "产品规格")
	@TableField("f_ordr_itemspec")
	private String fOrdrItemspec;
    /**
     * 产品序列号
     */
    @ApiModelProperty(value = "产品序列号")
	@TableField("f_order_itemserial")
	private String fOrderItemserial;
    /**
     * 产品颜色
     */
    @ApiModelProperty(value = "产品颜色")
	@TableField("f_order_itemcolor")
	private String fOrderItemcolor;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
	@TableField("f_order_qty")
	private Integer fOrderQty;
    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
	@TableField("f_order_until")
	private String fOrderUntil;
    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
	@TableField("f_order_source")
	private String fOrderSource;
    /**
     * 购买日期
     */
    @ApiModelProperty(value = "购买日期")
	@TableField("f_order_buydate")
	private String fOrderBuydate;
    /**
     * 销售人员
     */
    @ApiModelProperty(value = "销售人员")
	@TableField("f_order_owner")
	private String fOrderOwner;
    /**
     * 客户代码
     */
    @ApiModelProperty(value = "客户代码")
	@TableField("f_order_clientnumber")
	private String fOrderClientnumber;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
	@TableField("f_order_client")
	private String fOrderClient;
    /**
     * 客户电话1
     */
    @ApiModelProperty(value = "客户电话1")
	@TableField("f_order_tel1")
	private String fOrderTel1;
    /**
     * 客户电话2
     */
    @ApiModelProperty(value = "客户电话2")
	@TableField("f_order_tel2")
	private String fOrderTel2;
    /**
     * 客户地址
     */
    @ApiModelProperty(value = "客户地址")
	@TableField("f_order_caddress")
	private String fOrderCaddress;
    /**
     * 预约类型
     */
    @ApiModelProperty(value = "预约类型")
	@TableField("f_order_sertype")
	private String fOrderSertype;
    /**
     * 收费进金额
     */
    @ApiModelProperty(value = "收费进金额")
	@TableField("f_order_amount")
	private Double fOrderAmount;
    /**
     * 问题描述
     */
    @ApiModelProperty(value = "问题描述")
	@TableField("f_order_describe")
	private String fOrderDescribe;
    /**
     * 预约日期及时间
     */
    @ApiModelProperty(value = "预约日期及时间")
	@TableField("f_order_date")
	private String fOrderDate;
    /**
     * 服务技师
     */
    @ApiModelProperty(value = "服务技师")
	@TableField("f_order_serowner")
	private String fOrderSerowner;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
	@TableField("f_order_remark")
	private String fOrderRemark;
	@TableField("f_sort_id")
	private Integer fSortId;


	public String getfOrderSn() {
		return fOrderSn;
	}

	public void setfOrderSn(String fOrderSn) {
		this.fOrderSn = fOrderSn;
	
	}

	public String getfOrderItemnumber() {
		return fOrderItemnumber;
	}

	public void setfOrderItemnumber(String fOrderItemnumber) {
		this.fOrderItemnumber = fOrderItemnumber;
	
	}

	public String getfOrderItemnote() {
		return fOrderItemnote;
	}

	public void setfOrderItemnote(String fOrderItemnote) {
		this.fOrderItemnote = fOrderItemnote;
	}

	public String getfOrderItemname() {
		return fOrderItemname;
	}

	public void setfOrderItemname(String fOrderItemname) {
		this.fOrderItemname = fOrderItemname;
	
	}

	public String getfOrderItemmodel() {
		return fOrderItemmodel;
	}

	public void setfOrderItemmodel(String fOrderItemmodel) {
		this.fOrderItemmodel = fOrderItemmodel;
	
	}

	public String getfOrdrItemspec() {
		return fOrdrItemspec;
	}

	public void setfOrdrItemspec(String fOrdrItemspec) {
		this.fOrdrItemspec = fOrdrItemspec;
	
	}

	public String getfOrderItemserial() {
		return fOrderItemserial;
	}

	public void setfOrderItemserial(String fOrderItemserial) {
		this.fOrderItemserial = fOrderItemserial;
	
	}

	public String getfOrderItemcolor() {
		return fOrderItemcolor;
	}

	public void setfOrderItemcolor(String fOrderItemcolor) {
		this.fOrderItemcolor = fOrderItemcolor;
	
	}

	public Integer getfOrderQty() {
		return fOrderQty;
	}

	public void setfOrderQty(Integer fOrderQty) {
		this.fOrderQty = fOrderQty;
	
	}

	public String getfOrderUntil() {
		return fOrderUntil;
	}

	public void setfOrderUntil(String fOrderUntil) {
		this.fOrderUntil = fOrderUntil;
	
	}

	public String getfOrderSource() {
		return fOrderSource;
	}

	public void setfOrderSource(String fOrderSource) {
		this.fOrderSource = fOrderSource;
	
	}

	public String getfOrderBuydate() {
		return fOrderBuydate;
	}

	public void setfOrderBuydate(String fOrderBuydate) {
		this.fOrderBuydate = fOrderBuydate;
	
	}

	public String getfOrderOwner() {
		return fOrderOwner;
	}

	public void setfOrderOwner(String fOrderOwner) {
		this.fOrderOwner = fOrderOwner;
	
	}

	public String getfOrderClientnumber() {
		return fOrderClientnumber;
	}

	public void setfOrderClientnumber(String fOrderClientnumber) {
		this.fOrderClientnumber = fOrderClientnumber;
	
	}

	public String getfOrderClient() {
		return fOrderClient;
	}

	public void setfOrderClient(String fOrderClient) {
		this.fOrderClient = fOrderClient;
	
	}

	public String getfOrderTel1() {
		return fOrderTel1;
	}

	public void setfOrderTel1(String fOrderTel1) {
		this.fOrderTel1 = fOrderTel1;
	
	}

	public String getfOrderTel2() {
		return fOrderTel2;
	}

	public void setfOrderTel2(String fOrderTel2) {
		this.fOrderTel2 = fOrderTel2;
	
	}

	public String getfOrderCaddress() {
		return fOrderCaddress;
	}

	public void setfOrderCaddress(String fOrderCaddress) {
		this.fOrderCaddress = fOrderCaddress;
	
	}

	public String getfOrderSertype() {
		return fOrderSertype;
	}

	public void setfOrderSertype(String fOrderSertype) {
		this.fOrderSertype = fOrderSertype;
	
	}

	public Double getfOrderAmount() {
		return fOrderAmount;
	}

	public void setfOrderAmount(Double fOrderAmount) {
		this.fOrderAmount = fOrderAmount;
	
	}

	public String getfOrderDescribe() {
		return fOrderDescribe;
	}

	public void setfOrderDescribe(String fOrderDescribe) {
		this.fOrderDescribe = fOrderDescribe;
	
	}

	public String getfOrderDate() {
		return fOrderDate;
	}

	public void setfOrderDate(String fOrderDate) {
		this.fOrderDate = fOrderDate;
	
	}

	public String getfOrderSerowner() {
		return fOrderSerowner;
	}

	public void setfOrderSerowner(String fOrderSerowner) {
		this.fOrderSerowner = fOrderSerowner;
	
	}

	public String getfOrderRemark() {
		return fOrderRemark;
	}

	public void setfOrderRemark(String fOrderRemark) {
		this.fOrderRemark = fOrderRemark;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}