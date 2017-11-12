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
  * 创建日期：2017-11-6
  * </pre>
  */

package com.biggirlo.system.controller;

import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.jopo.parame.RoleMenuPalame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import com.biggirlo.system.model.SysRoleMenu;
import com.biggirlo.system.service.SysRoleMenuService;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/sys/role/menu")
public class SysRoleMenuController {
    
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("/{id}")
    public SysRoleMenu get(@PathVariable("id") Long id) {
        SysRoleMenu sysRoleMenu = null;
        //sysRoleMenu = sysRoleMenuService.get(id);

        return sysRoleMenu;
    }

    /**
     * 获取整个树结构
     * @return
     */
    @RequestMapping(value = "/tree/{roId}",method = RequestMethod.GET)
    public Restult getAllWholeTree(@PathVariable("roId")Long roId){
        Restult rs = new Restult();
        try {
            rs.setCodeData(Code.SUCCESS,sysRoleMenuService.getRoleUserTree(roId));
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs ;
    }

    /**
     * 保存分配的角色权限
     * @return
     */
    @RequestMapping(value = "/tree",method = RequestMethod.POST)
    public Restult saveRoleMenu(@RequestBody RoleMenuPalame palame){
        Restult rs = new Restult();
        try {
            rs.setCodeData(Code.SUCCESS,sysRoleMenuService.saveRoleMenu(palame));
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs ;
    }
}