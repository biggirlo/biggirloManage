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

package com.biggirlo.system.service;

import java.util.Collection;
import java.util.List;

import com.biggirlo.base.service.BaseService;
import com.biggirlo.system.jopo.jstree.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biggirlo.system.model.SysHandle;
import com.biggirlo.system.mapper.SysHandleMapper;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("sysHandleService")
public class SysHandleService extends BaseService<SysHandle, Long> {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysHandleMapper sysHandleMapper;

    /**
     * 得到包含菜单树结构和操作的结构树
     * @return
     */
    public List<TreeNode> getJsTreeList() {
        //得到菜单节点
        List<TreeNode> nodes = sysMenuService.getJsTreeList();
        //得到操作节点
        nodes.addAll(this.getHandleToTreeNode());
        return nodes;
    }

    /**
     * 得到TreeNode.class的操作列表
     * @return
     */
    public List<TreeNode> getHandleToTreeNode() {
        return sysHandleMapper.searchHandleToTreeNode();
    }
}