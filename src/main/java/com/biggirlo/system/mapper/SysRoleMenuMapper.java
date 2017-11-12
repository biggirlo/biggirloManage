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

package com.biggirlo.system.mapper;

import com.biggirlo.base.mapper.BaseMapper;
import com.biggirlo.system.jopo.TreeNode;
import com.biggirlo.system.jopo.parame.RoleMenuPalame;
import org.apache.ibatis.annotations.Mapper;
import com.biggirlo.system.model.SysRoleMenu;

import java.util.List;

/**
 * <pre>
 * 数据访问接口
 * </pre>
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 根据角色id获取树     */
    List<TreeNode> searchRoleUsers(Long roId);

    /**
     * 通过权限删除
     * @param roleId
     */
    int deleteByCondtion(Long roleId);

    /**
     * 批量插入参数
     * @param palame
     */
    int insertFromPalame(RoleMenuPalame palame);
}