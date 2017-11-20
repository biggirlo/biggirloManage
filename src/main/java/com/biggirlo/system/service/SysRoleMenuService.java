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

package com.biggirlo.system.service;

import java.util.Date;
import java.util.List;

import com.biggirlo.base.service.BaseService;
import com.biggirlo.system.jopo.jstree.TreeNode;
import com.biggirlo.system.jopo.parame.RoleMenuPalame;
import com.biggirlo.system.mapper.SysRoleMenuMapper;
import com.biggirlo.system.util.UserLoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biggirlo.system.model.SysRoleMenu;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("sysRoleMenuService")
public class SysRoleMenuService extends BaseService<SysRoleMenu, Long> {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    /**
     * 获取带角色权限的菜单树
     * @return
     */
    public Object getRoleUserTree(Long roId) {
        List<TreeNode> nodes = sysRoleMenuMapper.searchRoleUsers(roId);
        for(TreeNode nodeI : nodes) {
            for (TreeNode nodeJ : nodes) {
                if (nodeI.getId() == nodeJ.getParent()) {
                    nodeI.setSelect(false);
                    break;
                }
            }
            if(nodeI.isSelect())
                nodeI.setSelected();
        }

        //设置根节点
        TreeNode root = new TreeNode();
        root.setId("0");
        root.setText("菜单管理");
        root.setParent("#");
        nodes.add(root);

        return nodes;
    }

    /**
     * 保存角色-应用权限树
     * @param palame
     * @return
     */
    public Object saveRoleMenu(RoleMenuPalame palame) {
        //删除
        sysRoleMenuMapper.deleteByCondtion(palame.getRoleId());

        //设置参数
        palame.setCreateBy(UserLoginUtils.getCurrentUserId());
        palame.setCreateTime(new Date());
        int count = 0;
        if(palame.getMenuIds().size() >0)
            count = sysRoleMenuMapper.insertFromPalame(palame);

        return count;
    }
}