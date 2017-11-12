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

package com.biggirlo.system.controller;

import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.jopo.parame.UserRolePalame;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biggirlo.system.model.SysUserRole;
import com.biggirlo.system.service.SysUserRoleService;

import java.util.Map;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/sys/user/role")
public class SysUserRoleController {
    
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping("/{id}")
    public SysUserRole get(@PathVariable("id") Long id) {
        SysUserRole sysUserRole = null;
        sysUserRole = sysUserRoleService.selectById(id);

        return sysUserRole;
    }

    /**
     * 根据角色id获取对应用户
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public Object getUsersByRole(@PathVariable("id") Long id){
        try{
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(id);
            return new Restult(Code.SUCCESS, sysUserRoleService.selectUsersByRole(sysUserRole));
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }

    /**
     * 保存所分配用户
     * @return
     */
    @RequestMapping(value = "/users" ,method = RequestMethod.POST)
    public Object saveUserRoles(@RequestBody UserRolePalame palame){
        try{
            return new Restult(Code.SUCCESS , sysUserRoleService.saveUserRoles(palame));
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }
}