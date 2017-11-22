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

package com.biggirlo.system.mapper;

import com.biggirlo.base.mapper.BaseMapper;
import com.biggirlo.system.jopo.parame.RoleMenuPalame;
import org.apache.ibatis.annotations.Mapper;
import com.biggirlo.system.model.SysRoleHandle;

/**
 * <pre>
 * 数据访问接口
 * </pre>
 */
@Mapper
public interface SysRoleHandleMapper extends BaseMapper<SysRoleHandle> {
    /**
     * 批量插入
     * @param palame
     * @return
     */
    int insertFromPalame(RoleMenuPalame palame);
}