/**************************************************************************/
/**************************************************************************/
/*                                                                        */
/* Biggirlos                                       						  */
/* ************************************************************************/
/* 该项目仅用于学习
/* 有任何疑问或者建议请致邮件于 email:645614025@qq.com
/* **********************************************************
/* **********************************************************
*
/**************************************************************************/

/**
  * <pre>
  * 作   者：王雁欣
  * 创建日期：2017-9-9
  * </pre>
  */

package com.biggirlo.system.model;

import com.biggirlo.base.model.BaseModel;
import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <pre>
 * 实体类
 * 数据库表名称：bs_sys_menu
 * </pre>
 */
@Table(name = "BS_SYS_MENU")
public class SysMenu extends BaseModel{
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * 数据库字段信息:menu_code VARCHAR(100)
     */
    private String menuCode;

    /**
     * 
     * 
     * 数据库字段信息:menu_name VARCHAR(200)
     */
    private String menuName;

    /**
     * 
     * 
     * 数据库字段信息:url VARCHAR(400)
     */
    private String url;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 
     * 
     * 数据库字段信息:type CHAR(1)
     */
    private Long type;

    /**
     * 
     * 
     * 数据库字段信息:parent_id INT(10)
     */
    private Long parentId;

    /**
     *
     *
     * 排序
     */
    @OrderBy
    private Long sort;

    private Date createTime;
    /**
     * 子菜单
     */
    @Transient
    private List<SysMenu> menus = new ArrayList<>();

    public SysMenu() {
    }	
    public String getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
	
    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
	
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
	
    public Long getType() {
        return this.type;
    }

    public void setType(Long type) {
        this.type = type;
    }
	
    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }
}