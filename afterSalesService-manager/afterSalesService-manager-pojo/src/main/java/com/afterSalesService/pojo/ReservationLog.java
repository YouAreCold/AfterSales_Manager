package com.afterSalesService.pojo;

import io.swagger.annotations.ApiModelProperty;

import com.afterSalesService.common.base.pojo.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;



/**
 * <p>
 * 预约记录(关联预约表)
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
@SuppressWarnings("serial")
public class ReservationLog extends BaseModel {

    /**
     * 单号
     */
    @ApiModelProperty(value = "单号")
	@TableField("f_ordlog_sn")
	private String fOrdlogSn;
    /**
     * 产品代码
     */
    @ApiModelProperty(value = "产品代码")
	@TableField("f_ordlog_itemnumber")
	private String fOrdlogItemnumber;
    /**
     * 产品品牌
     */
    @ApiModelProperty(value = "产品品牌")
	@TableField("f_ordlog_itemnote")
	private String fOrdlogItemnote;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
	@TableField("f_ordlog_itemname")
	private String fOrdlogItemname;
    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
	@TableField("f_ordlog_itemmode")
	private String fOrdlogItemmode;
    /**
     * 产品规格
     */
    @ApiModelProperty(value = "产品规格")
	@TableField("f_ordlog_itemsepc")
	private String fOrdlogItemsepc;
    /**
     * 产品序列号
     */
    @ApiModelProperty(value = "产品序列号")
	@TableField("f_ordlog_itemserial")
	private String fOrdlogItemserial;
    /**
     * 产品颜色
     */
    @ApiModelProperty(value = "产品颜色")
	@TableField("f_ordlog_itemcolor")
	private String fOrdlogItemcolor;
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
	@TableField("f_ordlog_qty")
	private Integer fOrdlogQty;
    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
	@TableField("f_ordlog_until")
	private String fOrdlogUntil;
    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
	@TableField("f_ordlog_source")
	private String fOrdlogSource;
    /**
     * 购买日期
     */
    @ApiModelProperty(value = "购买日期")
	@TableField("f_ordlog_buydate")
	private String fOrdlogBuydate;
    /**
     * 销售人员
     */
    @ApiModelProperty(value = "销售人员")
	@TableField("f_ordlog_owner")
	private String fOrdlogOwner;
    /**
     * 客户代码
     */
    @ApiModelProperty(value = "客户代码")
	@TableField("f_ordlog_clientnumber")
	private String fOrdlogClientnumber;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
	@TableField("f_ordlog_client")
	private String fOrdlogClient;
    /**
     * 客户电话1
     */
    @ApiModelProperty(value = "客户电话1")
	@TableField("f_ordlog_tel1")
	private String fOrdlogTel1;
    /**
     * 客户电话2
     */
    @ApiModelProperty(value = "客户电话2")
	@TableField("f_ordlog_tel2")
	private String fOrdlogTel2;
    /**
     * 客户地址
     */
    @ApiModelProperty(value = "客户地址")
	@TableField("f_ordlog_caddress")
	private String fOrdlogCaddress;
    /**
     * 预约类型
     */
    @ApiModelProperty(value = "预约类型")
	@TableField("f_ordlog_sertype")
	private String fOrdlogSertype;
    /**
     * 收费金额
     */
    @ApiModelProperty(value = "收费金额")
	@TableField("f_ordlog_amount")
	private Double fOrdlogAmount;
    /**
     * 问题描述
     */
    @ApiModelProperty(value = "问题描述")
	@TableField("f_ordlog_describe")
	private String fOrdlogDescribe;
    /**
     * 预约日期及时间
     */
    @ApiModelProperty(value = "预约日期及时间")
	@TableField("f_ordlog_date")
	private String fOrdlogDate;
    /**
     * 服务技师
     */
    @ApiModelProperty(value = "服务技师")
	@TableField("f_ordlog_serowner")
	private String fOrdlogSerowner;
    /**
     * 服务状态
     */
    @ApiModelProperty(value = "服务状态")
	@TableField("f_ordlog_serstate")
	private String fOrdlogSerstate;
    /**
     * 服务内容
     */
    @ApiModelProperty(value = "服务内容")
	@TableField("f_ordlog_logdescribe")
	private String fOrdlogLogdescribe;
    /**
     * 客户意见
     */
    @ApiModelProperty(value = "客户意见")
	@TableField("f_ordlog_copinion")
	private String fOrdlogCopinion;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
	@TableField("f_ordlog_remark")
	private String fOrdlogRemark;
    /**
     * 上一次服务时间
     */
    @ApiModelProperty(value = "上一次服务时间")
	@TableField("f_ordlog_beserdate")
	private String fOrdlogBeserdate;
	@TableField("f_sort_id")
	private Integer fSortId;


	public String getfOrdlogSn() {
		return fOrdlogSn;
	}

	public void setfOrdlogSn(String fOrdlogSn) {
		this.fOrdlogSn = fOrdlogSn;
	
	}

	public String getfOrdlogItemnumber() {
		return fOrdlogItemnumber;
	}

	public void setfOrdlogItemnumber(String fOrdlogItemnumber) {
		this.fOrdlogItemnumber = fOrdlogItemnumber;
	
	}

	public String getfOrdlogItemnote() {
		return fOrdlogItemnote;
	}

	public void setfOrdlogItemnote(String fOrdlogItemnote) {
		this.fOrdlogItemnote = fOrdlogItemnote;
	
	}

	public String getfOrdlogItemname() {
		return fOrdlogItemname;
	}

	public void setfOrdlogItemname(String fOrdlogItemname) {
		this.fOrdlogItemname = fOrdlogItemname;
	
	}

	public String getfOrdlogItemmode() {
		return fOrdlogItemmode;
	}

	public void setfOrdlogItemmode(String fOrdlogItemmode) {
		this.fOrdlogItemmode = fOrdlogItemmode;
	
	}

	public String getfOrdlogItemsepc() {
		return fOrdlogItemsepc;
	}

	public void setfOrdlogItemsepc(String fOrdlogItemsepc) {
		this.fOrdlogItemsepc = fOrdlogItemsepc;
	
	}

	public String getfOrdlogItemserial() {
		return fOrdlogItemserial;
	}

	public void setfOrdlogItemserial(String fOrdlogItemserial) {
		this.fOrdlogItemserial = fOrdlogItemserial;
	
	}

	public String getfOrdlogItemcolor() {
		return fOrdlogItemcolor;
	}

	public void setfOrdlogItemcolor(String fOrdlogItemcolor) {
		this.fOrdlogItemcolor = fOrdlogItemcolor;
	
	}

	public Integer getfOrdlogQty() {
		return fOrdlogQty;
	}

	public void setfOrdlogQty(Integer fOrdlogQty) {
		this.fOrdlogQty = fOrdlogQty;
	
	}

	public String getfOrdlogUntil() {
		return fOrdlogUntil;
	}

	public void setfOrdlogUntil(String fOrdlogUntil) {
		this.fOrdlogUntil = fOrdlogUntil;
	
	}

	public String getfOrdlogSource() {
		return fOrdlogSource;
	}

	public void setfOrdlogSource(String fOrdlogSource) {
		this.fOrdlogSource = fOrdlogSource;
	
	}

	public String getfOrdlogBuydate() {
		return fOrdlogBuydate;
	}

	public void setfOrdlogBuydate(String fOrdlogBuydate) {
		this.fOrdlogBuydate = fOrdlogBuydate;
	
	}

	public String getfOrdlogOwner() {
		return fOrdlogOwner;
	}

	public void setfOrdlogOwner(String fOrdlogOwner) {
		this.fOrdlogOwner = fOrdlogOwner;
	
	}

	public String getfOrdlogClientnumber() {
		return fOrdlogClientnumber;
	}

	public void setfOrdlogClientnumber(String fOrdlogClientnumber) {
		this.fOrdlogClientnumber = fOrdlogClientnumber;
	
	}

	public String getfOrdlogClient() {
		return fOrdlogClient;
	}

	public void setfOrdlogClient(String fOrdlogClient) {
		this.fOrdlogClient = fOrdlogClient;
	
	}

	public String getfOrdlogTel1() {
		return fOrdlogTel1;
	}

	public void setfOrdlogTel1(String fOrdlogTel1) {
		this.fOrdlogTel1 = fOrdlogTel1;
	
	}

	public String getfOrdlogTel2() {
		return fOrdlogTel2;
	}

	public void setfOrdlogTel2(String fOrdlogTel2) {
		this.fOrdlogTel2 = fOrdlogTel2;
	
	}

	public String getfOrdlogCaddress() {
		return fOrdlogCaddress;
	}

	public void setfOrdlogCaddress(String fOrdlogCaddress) {
		this.fOrdlogCaddress = fOrdlogCaddress;
	
	}

	public String getfOrdlogSertype() {
		return fOrdlogSertype;
	}

	public void setfOrdlogSertype(String fOrdlogSertype) {
		this.fOrdlogSertype = fOrdlogSertype;
	
	}

	public Double getfOrdlogAmount() {
		return fOrdlogAmount;
	}

	public void setfOrdlogAmount(Double fOrdlogAmount) {
		this.fOrdlogAmount = fOrdlogAmount;
	
	}

	public String getfOrdlogDescribe() {
		return fOrdlogDescribe;
	}

	public void setfOrdlogDescribe(String fOrdlogDescribe) {
		this.fOrdlogDescribe = fOrdlogDescribe;
	
	}

	public String getfOrdlogDate() {
		return fOrdlogDate;
	}

	public void setfOrdlogDate(String fOrdlogDate) {
		this.fOrdlogDate = fOrdlogDate;
	
	}

	public String getfOrdlogSerowner() {
		return fOrdlogSerowner;
	}

	public void setfOrdlogSerowner(String fOrdlogSerowner) {
		this.fOrdlogSerowner = fOrdlogSerowner;
	
	}

	public String getfOrdlogSerstate() {
		return fOrdlogSerstate;
	}

	public void setfOrdlogSerstate(String fOrdlogSerstate) {
		this.fOrdlogSerstate = fOrdlogSerstate;
	
	}

	public String getfOrdlogLogdescribe() {
		return fOrdlogLogdescribe;
	}

	public void setfOrdlogLogdescribe(String fOrdlogLogdescribe) {
		this.fOrdlogLogdescribe = fOrdlogLogdescribe;
	
	}

	public String getfOrdlogCopinion() {
		return fOrdlogCopinion;
	}

	public void setfOrdlogCopinion(String fOrdlogCopinion) {
		this.fOrdlogCopinion = fOrdlogCopinion;
	
	}

	public String getfOrdlogRemark() {
		return fOrdlogRemark;
	}

	public void setfOrdlogRemark(String fOrdlogRemark) {
		this.fOrdlogRemark = fOrdlogRemark;
	
	}

	public String getfOrdlogBeserdate() {
		return fOrdlogBeserdate;
	}

	public void setfOrdlogBeserdate(String fOrdlogBeserdate) {
		this.fOrdlogBeserdate = fOrdlogBeserdate;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}