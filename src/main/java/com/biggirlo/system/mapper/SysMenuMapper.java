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

package com.biggirlo.system.mapper;

import com.biggirlo.base.mapper.BaseMapper;
import com.biggirlo.system.jopo.search.MenuRoleSearch;
import com.biggirlo.system.model.SysMenu;


import java.util.List;

/**
 * <pre>
 * 数据访问接口
 * </pre>
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据条件查询
     * @param menuSearch
     * @return
     */
    List<SysMenu> selectByRolesAuth(MenuRoleSearch menuSearch);
}