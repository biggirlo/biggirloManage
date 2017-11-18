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
import com.biggirlo.base.util.DataTablesParam;
import com.biggirlo.base.util.Restult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biggirlo.system.model.SysRole;
import com.biggirlo.system.service.SysRoleService;

import java.util.Map;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/sys/role")
public class SysRoleController {
    
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/{id}")
    public Object get(@PathVariable("id") Long id) {
        try{
            return new Restult(Code.SUCCESS,sysRoleService.selectById(id));
        }catch (Exception e){
            return new Restult(Code.SYSTEM_ERROR);
        }
    }

    /**
     * 获取所有的角色列表
     * @param param
     * @param role
     * @return
     */
    @RequestMapping(value = "/datables/list",method = RequestMethod.PUT)
    public Object getList(DataTablesParam param, SysRole role){
        //分页查询
        return sysRoleService.selectByDatetable(param,role);
    }

    /**
     * 新增
     * @param role
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Object create(@RequestBody SysRole role){
        try{
            return sysRoleService.save(role);
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }

    /**
     * 删除
     * @param map
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.DELETE)
    public Object delete(@RequestBody Map<String ,Long[]> map){
        try{
            Long[] ids = map.get("ids");
            return new Restult(Code.SUCCESS,sysRoleService.deleteByIds(ids));
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }
}