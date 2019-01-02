package com.afterSalesService.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("sys_menu")
@SuppressWarnings("serial")
public class SysMenu extends BaseModel {

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
	@TableField("menu_name")
	private String menuName;
    /**
     * 表ID
     */
    @ApiModelProperty(value = "表ID")
	@TableField("menu_id")
	private String menuId;
    /**
     * 父节点
     */
	@TableField("parent_id")
	private Integer parentId;
	
	/**
	 * 菜单对应路径
	 */
	@TableField("menu_url")
	private String menuUrl;
	
	/**
	 * 图标code
	 */
	@TableField("icon_code")
	private String iconCode;
	
	@TableField("sort_id")
	private Integer sortId;
	
	public String getIconCode() {
		return iconCode;
	}

	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	
	}

}