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
  * 创建日期：2017-11-22
  * </pre>
  */

package com.biggirlo.system.model;

import java.sql.Timestamp;
import java.sql.Date;

import com.biggirlo.base.model.BaseModel;

import javax.persistence.Table;

/**
 * <pre>
 * 实体类
 * 数据库表名称：bs_sys_role_handle
 * </pre>
 */
@Table(name="BS_SYS_ROLE_HANDLE")
public class SysRoleHandle extends BaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * 数据库字段信息:role_id INT(10)
     */
    private Long roleId;

    /**
     * 
     * 
     * 数据库字段信息:handle_id INT(10)
     */
    private Long handleId;

    /**
     * 
     * 
     * 数据库字段信息:create_time DATETIME(19)
     */
    private Timestamp createTime;

    /**
     * 
     * 
     * 数据库字段信息:create_by INT(10)
     */
    private Long createBy;

    /**
     * 
     * 
     * 数据库字段信息:update_by INT(10)
     */
    private Long updateBy;

    /**
     * 
     * 
     * 数据库字段信息:update_time DATETIME(19)
     */
    private Timestamp updateTime;

    public SysRoleHandle() {
    }	
    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	
    public Long getHandleId() {
        return this.handleId;
    }

    public void setHandleId(Long handleId) {
        this.handleId = handleId;
    }
	
    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
	
    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
	
    public Long getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
	
    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}