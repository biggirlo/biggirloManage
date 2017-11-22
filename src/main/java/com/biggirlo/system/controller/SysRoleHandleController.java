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
  * 创建日期：2017-11-22
  * </pre>
  */

package com.biggirlo.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biggirlo.system.service.SysRoleHandleService;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
@RequestMapping(value = "/user/sysRoleHandle")
public class SysRoleHandleController {
    
    @Autowired
    private SysRoleHandleService sysRoleHandleService;

}