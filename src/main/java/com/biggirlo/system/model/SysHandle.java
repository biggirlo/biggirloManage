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

import java.sql.Timestamp;

import com.biggirlo.base.model.BaseModel;

import javax.persistence.Table;

/**
 * <pre>
 * 实体类
 * 数据库表名称：bs_sys_handle
 * </pre>
 */
@Table(name = "BS_SYS_HANDLE")
public class SysHandle extends BaseModel{

    /**
     *
     *
     * 数据库字段信息:menu_id INT(10)
     */
    private Long menuId;

    /**
     *
     *
     * 数据库字段信息:handle_code VARCHAR(150)
     */
    private String handleCode;

    /**
     *
     *
     * 数据库字段信息:name VARCHAR(150)
     */
    private String name;

    /**
     *
     *
     * 数据库字段信息:url VARCHAR(400)
     */
    private String url;

    /**
     *
     *
     * 数据库字段信息:type CHAR(1)
     */
    private String type;

    /**
     *
     *
     * 数据库字段信息:is_available TINYINT(3)
     */
    private Integer isAvailable;

    public SysHandle() {
    }
    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getHandleCode() {
        return this.handleCode;
    }

    public void setHandleCode(String handleCode) {
        this.handleCode = handleCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

}