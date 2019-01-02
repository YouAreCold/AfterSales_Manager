package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.afterSalesService.common.base.pojo.BaseModel;

import io.swagger.annotations.ApiModelProperty;



/**
 * <p>
 * 工作计划
 * </p>
 *
 * @author wjx
 * @since 2018-10-20
 */
@SuppressWarnings("serial")
public class Plant extends BaseModel {

    /**
     * 创建计划日期
     */
    @ApiModelProperty(value = "创建计划日期")
	@TableField("f_plant_date")
	private String fPlantDate;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
	@TableField("f_plant_owner")
	private String fPlantOwner;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
	@TableField("f_plant_level")
	private String fPlantLevel;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
	@TableField("f_plant_content")
	private String fPlantContent;
    /**
     * 主管意见
     */
    @ApiModelProperty(value = "主管意见")
	@TableField("f_plant_opinion")
	private String fPlantOpinion;
    /**
     * 审核人日期
     */
    @ApiModelProperty(value = "审核人日期")
	@TableField("f_plant_checkdate")
	private String fPlantCheckdate;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
	@TableField("f_plant_checker")
	private String fPlantChecker;
	@TableField("f_sort_id")
	private Integer fSortId;


	public String getfPlantDate() {
		return fPlantDate;
	}

	public void setfPlantDate(String fPlantDate) {
		this.fPlantDate = fPlantDate;
	
	}

	public String getfPlantOwner() {
		return fPlantOwner;
	}

	public void setfPlantOwner(String fPlantOwner) {
		this.fPlantOwner = fPlantOwner;
	
	}

	public String getfPlantLevel() {
		return fPlantLevel;
	}

	public void setfPlantLevel(String fPlantLevel) {
		this.fPlantLevel = fPlantLevel;
	
	}

	public String getfPlantContent() {
		return fPlantContent;
	}

	public void setfPlantContent(String fPlantContent) {
		this.fPlantContent = fPlantContent;
	
	}

	public String getfPlantOpinion() {
		return fPlantOpinion;
	}

	public void setfPlantOpinion(String fPlantOpinion) {
		this.fPlantOpinion = fPlantOpinion;
	
	}

	public String getfPlantCheckdate() {
		return fPlantCheckdate;
	}

	public void setfPlantCheckdate(String fPlantCheckdate) {
		this.fPlantCheckdate = fPlantCheckdate;
	
	}

	public String getfPlantChecker() {
		return fPlantChecker;
	}

	public void setfPlantChecker(String fPlantChecker) {
		this.fPlantChecker = fPlantChecker;
	
	}

	public Integer getfSortId() {
		return fSortId;
	}

	public void setfSortId(Integer fSortId) {
		this.fSortId = fSortId;
	
	}

}