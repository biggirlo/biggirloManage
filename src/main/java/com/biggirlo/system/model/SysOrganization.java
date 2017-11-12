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
 * 数据库表名称：bs_sys_organization
 * </pre>
 */
@Table(name = "BS_SYSORGANIZATION")
public class SysOrganization extends BaseModel{
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * 数据库字段信息:parent_id INT(10)
     */
    private Long parentId;

    /**
     * 
     * 
     * 数据库字段信息:organization_code VARCHAR(50)
     */
    private String organizationCode;

    /**
     * 
     * 
     * 数据库字段信息:name VARCHAR(150)
     */
    private String name;

    /**
     * 
     * 
     * 数据库字段信息:summary VARCHAR(1000)
     */
    private String summary;

    /**
     * 
     * 
     * 数据库字段信息:remark VARCHAR(1000)
     */
    private String remark;

    /**
     * 
     * 
     * 数据库字段信息:is_available TINYINT(3)
     */
    private int isAvailable;

    public SysOrganization() {
    }	
    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
	
    public String getOrganizationCode() {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
	
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
	
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
	
    public int getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

}