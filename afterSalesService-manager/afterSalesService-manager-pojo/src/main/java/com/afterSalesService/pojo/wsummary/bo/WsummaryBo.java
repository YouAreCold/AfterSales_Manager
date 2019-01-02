package com.afterSalesService.pojo.wsummary.bo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 工作总结
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
@SuppressWarnings("serial")
public class WsummaryBo extends BaseModel {

    /**
     * 工作计划表ID
     */
    @ApiModelProperty(value = "工作计划表ID")
	@TableField("f_wsummary_pid")
	private Integer fWsummaryPid;
    /**
     * 总结日期
     */
    @ApiModelProperty(value = "总结日期")
	@TableField("f_wsummary_date")
	private String fWsummaryDate;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
	@TableField("f_wsummary_owner")
	private String fWsummaryOwner;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
	@TableField("f_wsummary_level")
	private String fWsummaryLevel;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
	@TableField("f_wsummary_content")
	private String fWsummaryContent;
    /**
     * 主管意见
     */
    @ApiModelProperty(value = "主管意见")
	@TableField("f_wsummary_opinion")
	private String fWsummaryOpinion;
    /**
     * 审核日期
     */
    @ApiModelProperty(value = "审核日期")
	@TableField("f_wsummary_checkdate")
	private String fWsummaryCheckdate;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
	@TableField("f_wsummary_checker")
	private String fWsummaryChecker;
	@TableField("f_sort_id")
	private Integer fSortId;


	public Integer getfWsummaryPid() {
		return fWsummaryPid;
	}

	public void setfWsummaryPid(Integer fWsummaryPid) {
		this.fWsummaryPid = fWsummaryPid;
	
	}

	public String getfWsummaryDate() {
		return fWsummaryDate;
	}

	public void setfWsummaryDate(String fWsummaryDate) {
		this.fWsummaryDate = fWsummaryDate;
	
	}

	public String getfWsummaryOwner() {
		return fWsummaryOwner;
	}

	public void setfWsummaryOwner(String fWsummaryOwner) {
		this.fWsummaryOwner = fWsummaryOwner;
	
	}

	public String getfWsummaryLevel() {
		return fWsummaryLevel;
	}

	public void setfWsummaryLevel(String fWsummaryLevel) {
		this.fWsummaryLevel = fWsummaryLevel;
	
	}

	public String getfWsummaryContent() {
		return fWsummaryContent;
	}

	public void setfWsummaryContent(String fWsummaryContent) {
		this.fWsummaryContent = fWsummaryContent;
	
	}

	public String getfWsummaryOpinion() {
		return fWsummaryOpinion;
	}

	public void setfWsummaryOpinion(String fWsummaryOpinion) {
		this.fWsummaryOpinion = fWsummaryOpinion;
	
	}

	public String getfWsummaryCheckdate() {
		return fWsummaryCheckdate;
	}

	public void setfWsummaryCheckdate(String fWsummaryCheckdate) {
		this.fWsummaryCheckdate = fWsummaryCheckdate;
	
	}

	public String getfWsummaryChecker() {
		return fWsummaryChecker;
	}

	public void setfWsummaryChecker(String fWsummaryChecker) {
		this.fWsummaryChecker = fWsummaryChecker;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}