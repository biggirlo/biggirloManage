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
import com.biggirlo.system.model.SysMenu;
import com.biggirlo.system.service.SysMenuService;

import java.util.Map;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/sys/menu")
public class SysMenuController {
    
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Restult get(@PathVariable("id") Long id) {
        Restult rs = new Restult();
        try{
            SysMenu sysMenu  = sysMenuService.selectById(id);
            rs.setCodeData(Code.SUCCESS,sysMenu);
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs ;
    }

    /**
     * 新增
     * @param menu
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Object create(@RequestBody SysMenu menu){
        try{
            return sysMenuService.save(menu);
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }

    /**
     * 左侧菜单列表
     * @return
     */
    @RequestMapping("/tree")
    public Restult getTree(){
        Restult rs = new Restult();
        try{
            rs.setCodeData(Code.SUCCESS,sysMenuService.getTreeList());
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs;
    }

    /**
     * 获取整个jstree树结构
     * @return
     */
    @RequestMapping(value = "/wholeTree",method = RequestMethod.GET)
    public Restult getAllJsTree(){
        Restult rs = new Restult();
        try {
            rs.setCodeData(Code.SUCCESS,sysMenuService.getJsTreeList());
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs ;
    }

    /**
     * 获取菜单列表
     * @param param
     * @param menu
     * @return
     */
    @RequestMapping(value = "/dataTable/list",method = RequestMethod.PUT)
    public Object getMenus(DataTablesParam param, SysMenu menu){
        return sysMenuService.selectByDatetable(param,menu);
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
            return new Restult(Code.SUCCESS,sysMenuService.deletes(ids));
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }
}