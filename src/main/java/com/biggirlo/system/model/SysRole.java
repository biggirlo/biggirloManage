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

import javax.persistence.Table;


/**
 * <pre>
 * 实体类
 * 数据库表名称：bs_sys_role
 * </pre>
 */
@Table(name = "BS_SYS_ROLE")
public class SysRole extends BaseModel{
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * 数据库字段信息:role_code VARCHAR(100)
     */
    private String roleCode;

    /**
     * 
     * 
     * 数据库字段信息:role_name VARCHAR(150)
     */
    private String roleName;

    /**
     * 
     * 
     * 数据库字段信息:remark VARCHAR(1000)
     */
    private String remark;

    public SysRole() {
    }	
    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
	
    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
	
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}