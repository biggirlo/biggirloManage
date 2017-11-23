/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.system.controller;

import com.biggirlo.base.config.shiro.ShiroApplicationConfig;
import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.mapper.SysUserMapper;
import com.biggirlo.system.model.SysUser;
import com.biggirlo.system.service.SysUserService;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 王雁欣
 * create on 2017/10/18 0:45 
 */
@RestController
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 无权限返回码
     * @return
     */
    @RequestMapping(value = "/unLogin")
    public Restult unLoading(){
        return new Restult(Code.UN_LOGIN);
    }

    /**
     * 登录验证
     * @return
     */
    @RequestMapping(value = "/system/login",method = RequestMethod.POST)
    public Restult login(@RequestBody SysUser user){
        return sysUserService.login(user);

    }

    /**
     * 无权限访问
     * @return
     */
    @RequestMapping(value = "/forbidden")
    public Restult forbidden(){
        return new Restult(Code.FORBIDDEN);
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout")
    public Restult logout(){
        try {
            sysUserService.logout();
            return new Restult(Code.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }
}
