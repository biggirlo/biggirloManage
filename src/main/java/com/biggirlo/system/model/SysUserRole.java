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
 * 数据库表名称：bs_sys_user_role
 * </pre>
 */
@Table(name = "BS_SYS_USER_ROLE")
public class SysUserRole extends BaseModel{
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
     * 数据库字段信息:user_id INT(10)
     */
    private Long userId;


    public SysUserRole() {
    }	
    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}