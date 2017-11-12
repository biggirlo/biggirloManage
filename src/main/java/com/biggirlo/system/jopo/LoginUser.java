/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.jopo;

import com.biggirlo.system.model.SysUser;
import com.biggirlo.system.model.SysUserRole;

import java.util.Date;

/**
 * 当前登录人信息
 * @author 王雁欣
 * create on 2017/11/5 18:12 
 */
public class LoginUser {

    //登陆人
    private SysUser user ;

    //登录时间
    private Date loginTime;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
