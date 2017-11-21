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
import java.util.Date;
import java.util.List;

import com.biggirlo.base.service.BaseService;
import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.jopo.jstree.Data;
import com.biggirlo.system.jopo.jstree.TreeNode;
import com.biggirlo.system.jopo.jstree.TreeNodeType;
import com.biggirlo.system.util.UserLoginUtils;
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
        List<TreeNode> doNodes = this.getHandleToTreeNode();
        for(TreeNode node : doNodes){
            Data data = new Data();
            //存入data缓存
            data.setId(node.getId());
            //修改id,避免冲突
            node.setId(  "-" + node.getId());
            //设置为操作类型
            data.setType(TreeNodeType.HANDLE);
            node.setData(data);
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * 得到TreeNode.class的操作列表
     * @return
     */
    public List<TreeNode> getHandleToTreeNode() {
        return sysHandleMapper.searchHandleToTreeNode();
    }

    public Object save(SysHandle handle) {
        Restult rs ;
        SysHandle handleTemp = new SysHandle();
        handleTemp.setHandleCode(handle.getHandleCode());
        handleTemp = selectOne(handleTemp);
        if(handle.getId() != null && (handleTemp == null || handleTemp.getId() ==  handle.getId()) ) {
            handle.setUpdateTime(new Date());
            handle.setUpdateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, update(handle));
        }else if (handle.getId() == null && handleTemp == null) {
            handle.setCreateTime(new Date());
            handle.setCreateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, insert(handle));
        } else
            rs = new Restult(Code.REPEAT_KEYWORK.value(),"重复的操作编码");

        return rs;
    }
}