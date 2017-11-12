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

package com.biggirlo.system.jopo;

import com.biggirlo.base.model.BaseModel;

/**
 * <pre>
 * 带用户信息的的角色-用户关系
 * </pre>
 */

public class SysRoleUserInfo extends BaseModel{
    private static final long serialVersionUID = 1L;

    /**
     *
     *
     */
    private Long roleId;

    /**
     *
     *
     * 数据库字段信息:user_id INT(10)
     */
    private Long userId;

    private String name;

    public SysRoleUserInfo() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}