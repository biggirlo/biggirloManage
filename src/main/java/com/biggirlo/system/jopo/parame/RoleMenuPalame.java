/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.jopo.parame;

import com.biggirlo.system.model.SysUserRole;

import java.util.Date;
import java.util.List;

/**
 * 保存角色-权限请求
 * @author 王雁欣
 * create on 2017/11/7 23:34 
 */
public class RoleMenuPalame {

    private Long roleId;

    private List<Long> menuIds;

    private Date createTime;

    private Long createBy;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

}
