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
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biggirlo.system.model.SysUser;
import com.biggirlo.system.service.SysUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController {
    
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Restult get(@PathVariable("id") Long id) {
        try{
            return new Restult(Code.SUCCESS,sysUserService.selectById(id));
        }catch (Exception e){
            return new Restult(Code.SYSTEM_ERROR);
        }
    }

    /**
     * 获取所有的用户列表
     * @param param
     * @param user
     * @return
     */
    @RequestMapping(value = "/datables/list",method = RequestMethod.PUT)
    public Object getList( DataTablesParam param,SysUser user){
        //分页查询
        return sysUserService.selectByDatetable(param,user);
    }

    /**
     * 更新数据
     * @param user
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Object update(@RequestBody SysUser user){
        return null;
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Object save(@RequestBody SysUser user){
        try{
            return sysUserService.save(user);
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
            return new Restult(Code.SUCCESS,sysUserService.deleteItems(ids));
        }catch (Exception e){
            e.printStackTrace();
            return new Restult(Code.SYSTEM_ERROR);
        }
    }
}