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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biggirlo.system.model.SysHandle;
import com.biggirlo.system.service.SysHandleService;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/sys/handle")
public class SysHandleController {
    
    @Autowired
    private SysHandleService sysHandleService;

    /**
     * 获取单个资源
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Restult get(@PathVariable("id") Long id) {
        Restult rs = new Restult();
        try{
            SysHandle sysMenu  = sysHandleService.selectById(id);
            rs.setCodeData(Code.SUCCESS,sysMenu);
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs ;
    }

    /**
     * 获取整个jstree树结构
     * @return
     */
    @RequestMapping(value = "/jsTree",method = RequestMethod.GET)
    public Restult getAllJsTree(){
        Restult rs = new Restult();
        try {
            rs.setCodeData(Code.SUCCESS,sysHandleService.getJsTreeList());
        }catch (Exception e){
            e.printStackTrace();
            rs.setCode(Code.SYSTEM_ERROR);
        }
        return rs ;
    }
}