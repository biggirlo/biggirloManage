/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.jopo.search;

import com.biggirlo.system.model.SysUserRole;

import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2017/11/15 1:55 
 */
public class MenuRoleSearch {
    //用户角色列表
    private List<SysUserRole> roles;

    //菜单类型
    private Long menuType;

    public List<SysUserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysUserRole> roles) {
        this.roles = roles;
    }

    public Long getMenuType() {
        return menuType;
    }

    public void setMenuType(Long menuType) {
        this.menuType = menuType;
    }
}
