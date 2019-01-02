package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 购买记录(会员模快)
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
@SuppressWarnings("serial")
public class Sell extends BaseModel {

    /**
     * 单号
     */
    @ApiModelProperty(value = "单号")
	@TableField("f_sell_sn")
	private String fSellSn;
    /**
     * 产品代码
     */
    @ApiModelProperty(value = "产品代码")
	@TableField("f_sell_itemnumber")
	private String fSellItemnumber;
    /**
     * 产品品牌
     */
    @ApiModelProperty(value = "产品品牌")
	@TableField("f_sell_itemnote")
	private String fSellItemnote;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
	@TableField("f_sell_itemname")
	private String fSellItemname;
    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
	@TableField("f_sell_itemmode")
	private String fSellItemmode;
    /**
     * 产品规格
     */
    @ApiModelProperty(value = "产品规格")
	@TableField("f_sell_itemspec")
	private String fSellItemspec;
    /**
     * 产品序列号
     */
    @ApiModelProperty(value = "产品序列号")
	@TableField("f_sell_itemserial")
	private String fSellItemserial;
    /**
     * 产品颜色
     */
    @ApiModelProperty(value = "产品颜色")
	@TableField("f_sell_itemcolor")
	private String fSellItemcolor;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
	@TableField("f_sell_qty")
	private Integer fSellQty;
    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
	@TableField("f_sell_until")
	private String fSellUntil;
    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
	@TableField("f_sell_source")
	private String fSellSource;
    /**
     * 购买日期
     */
    @ApiModelProperty(value = "购买日期")
	@TableField("f_sell_buydate")
	private String fSellBuydate;
    /**
     * 销售人员
     */
    @ApiModelProperty(value = "销售人员")
	@TableField("f_sell_owner")
	private String fSellOwner;
    /**
     * 客户代码
     */
    @ApiModelProperty(value = "客户代码")
	@TableField("f_sell_clientnumber")
	private String fSellClientnumber;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
	@TableField("f_sell_client")
	private String fSellClient;
    /**
     * 客户电话1
     */
    @ApiModelProperty(value = "客户电话1")
	@TableField("f_sell_tel1")
	private String fSellTel1;
    /**
     * 客户电话2
     */
    @ApiModelProperty(value = "客户电话2")
	@TableField("f_sell_tel2")
	private String fSellTel2;
    /**
     * 客户地址
     */
    @ApiModelProperty(value = "客户地址")
	@TableField("f_sell_caddress")
	private String fSellCaddress;
    /**
     * 购买服务
     */
    @ApiModelProperty(value = "购买服务")
	@TableField("f_sell_buytype")
	private String fSellBuytype;
    /**
     * 收费金额
     */
    @ApiModelProperty(value = "收费金额")
	@TableField("f_sell_amount")
	private Double fSellAmount;
    /**
     * 服务次数
     */
    @ApiModelProperty(value = "服务次数")
	@TableField("f_sell_servcecnt")
	private Integer fSellServcecnt;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
	@TableField("f_sell_remark")
	private String fSellRemark;
	@TableField("f_sort_id")
	private Integer fSortId;


	public String getfSellSn() {
		return fSellSn;
	}

	public void setfSellSn(String fSellSn) {
		this.fSellSn = fSellSn;
	
	}

	public String getfSellItemnumber() {
		return fSellItemnumber;
	}

	public void setfSellItemnumber(String fSellItemnumber) {
		this.fSellItemnumber = fSellItemnumber;
	
	}

	public String getfSellItemnote() {
		return fSellItemnote;
	}

	public void setfSellItemnote(String fSellItemnote) {
		this.fSellItemnote = fSellItemnote;
	
	}

	public String getfSellItemname() {
		return fSellItemname;
	}

	public void setfSellItemname(String fSellItemname) {
		this.fSellItemname = fSellItemname;
	
	}

	public String getfSellItemmode() {
		return fSellItemmode;
	}

	public void setfSellItemmode(String fSellItemmode) {
		this.fSellItemmode = fSellItemmode;
	
	}

	public String getfSellItemspec() {
		return fSellItemspec;
	}

	public void setfSellItemspec(String fSellItemspec) {
		this.fSellItemspec = fSellItemspec;
	
	}

	public String getfSellItemserial() {
		return fSellItemserial;
	}

	public void setfSellItemserial(String fSellItemserial) {
		this.fSellItemserial = fSellItemserial;
	
	}

	public String getfSellItemcolor() {
		return fSellItemcolor;
	}

	public void setfSellItemcolor(String fSellItemcolor) {
		this.fSellItemcolor = fSellItemcolor;
	
	}

	public Integer getfSellQty() {
		return fSellQty;
	}

	public void setfSellQty(Integer fSellQty) {
		this.fSellQty = fSellQty;
	
	}

	public String getfSellUntil() {
		return fSellUntil;
	}

	public void setfSellUntil(String fSellUntil) {
		this.fSellUntil = fSellUntil;
	
	}

	public String getfSellSource() {
		return fSellSource;
	}

	public void setfSellSource(String fSellSource) {
		this.fSellSource = fSellSource;
	
	}

	public String getfSellBuydate() {
		return fSellBuydate;
	}

	public void setfSellBuydate(String fSellBuydate) {
		this.fSellBuydate = fSellBuydate;
	
	}

	public String getfSellOwner() {
		return fSellOwner;
	}

	public void setfSellOwner(String fSellOwner) {
		this.fSellOwner = fSellOwner;
	
	}

	public String getfSellClientnumber() {
		return fSellClientnumber;
	}

	public void setfSellClientnumber(String fSellClientnumber) {
		this.fSellClientnumber = fSellClientnumber;
	
	}

	public String getfSellClient() {
		return fSellClient;
	}

	public void setfSellClient(String fSellClient) {
		this.fSellClient = fSellClient;
	
	}

	public String getfSellTel1() {
		return fSellTel1;
	}

	public void setfSellTel1(String fSellTel1) {
		this.fSellTel1 = fSellTel1;
	
	}

	public String getfSellTel2() {
		return fSellTel2;
	}

	public void setfSellTel2(String fSellTel2) {
		this.fSellTel2 = fSellTel2;
	
	}

	public String getfSellCaddress() {
		return fSellCaddress;
	}

	public void setfSellCaddress(String fSellCaddress) {
		this.fSellCaddress = fSellCaddress;
	
	}

	public String getfSellBuytype() {
		return fSellBuytype;
	}

	public void setfSellBuytype(String fSellBuytype) {
		this.fSellBuytype = fSellBuytype;
	
	}

	public Double getfSellAmount() {
		return fSellAmount;
	}

	public void setfSellAmount(Double fSellAmount) {
		this.fSellAmount = fSellAmount;
	
	}

	public Integer getfSellServcecnt() {
		return fSellServcecnt;
	}

	public void setfSellServcecnt(Integer fSellServcecnt) {
		this.fSellServcecnt = fSellServcecnt;
	
	}

	public String getfSellRemark() {
		return fSellRemark;
	}

	public void setfSellRemark(String fSellRemark) {
		this.fSellRemark = fSellRemark;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}