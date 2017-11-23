/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.util;

import com.biggirlo.system.jopo.LoginUser;
import org.apache.shiro.SecurityUtils;

/**
 *  用户登录相关工具类
 * @author 王雁欣
 * create on 2017/11/5 17:20 
 */
public class UserLoginUtils {

    //保存到session的名字
    public static final String LOGIN_USER_SESSION_NAME = "currentUser";
    //用户所拥有的角色的名称
    public static final String LOGIN_USER_ROLES_NAME = "userRoles";
    //用户菜单
    public static final String LOGIN_USER_MENUS_NAME ="userMenus";
    //用户操作
    public static final String LOGIN_USER_HANDLE_NAME ="userHandles";



    //默认密码
    public static final String DEFAUTE_PASSWORD ="123456";

    /**
     * 得到当前登陆人
     * @return
     */
    public static final LoginUser getCurrentUser(){
        return  (LoginUser) SecurityUtils.getSubject().getSession().getAttribute(LOGIN_USER_SESSION_NAME);
    }

    /**
     * 当前登录人id
     * @return
     */
    public static final Long getCurrentUserId(){
        return getCurrentUser().getUser().getId();
    }
}
