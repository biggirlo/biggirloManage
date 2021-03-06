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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.biggirlo.base.config.shiro.authenurl.URL;
import com.biggirlo.base.config.shiro.authenurl.UrlArryListUtil;
import com.biggirlo.base.service.BaseService;
import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.jopo.jstree.Data;
import com.biggirlo.system.jopo.jstree.TreeNode;
import com.biggirlo.system.jopo.jstree.TreeNodeType;
import com.biggirlo.system.jopo.search.HandleRoleSearch;
import com.biggirlo.system.jopo.search.MenuRoleSearch;
import com.biggirlo.system.mapper.SysRoleHandleMapper;
import com.biggirlo.system.model.*;
import com.biggirlo.system.util.UserLoginUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private SysRoleHandleMapper sysRoleHandleMapper;
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
        //更新缓存
        List<SysHandle> handles= UrlArryListUtil.getInstance().getSysHandles();

        //转大写
        if(handle.getType() != null)
            handle.setType(handle.getType().toUpperCase());

        Restult rs ;
        SysHandle handleTemp = new SysHandle();
        handleTemp.setHandleCode(handle.getHandleCode());
        handleTemp = selectOne(handleTemp);
        if(handle.getId() != null && (handleTemp == null || handleTemp.getId() ==  handle.getId()) ) {
            handle.setUpdateTime(new Date());
            handle.setUpdateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, update(handle));

            int result = this.getHandlsListIndex(handles,handle);
            if(result >= 0)
                 handles.set(result,handle);

        }else if (handle.getId() == null && handleTemp == null) {
            handle.setCreateTime(new Date());
            handle.setCreateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, insert(handle));
            handles.add(handle);
        } else
            rs = new Restult(Code.REPEAT_KEYWORK.value(),"重复的操作编码");

        return rs;
    }

    /**
     * 根据角色获取所有的操作
     * @param sysRoles
     * @return
     */
    public List<SysHandle> getHandleByRoles(List<SysUserRole> sysRoles){
        HandleRoleSearch search = new HandleRoleSearch();
        search.setRoles(sysRoles);
        return sysHandleMapper.searchByRoles(search);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deletesByIds(Long[] ids) {
        int count = 0;
        count = deletes(ids);

        //删除该用户拥有的角色关系
        List<SysRoleHandle> roleHandles = new ArrayList<>();
        for(long id : ids){
            SysRoleHandle roleHandle = new SysRoleHandle();
            roleHandle.setRoleId(id);
            roleHandles.add(roleHandle);
        }
        count += sysRoleHandleMapper.deleteList(roleHandles);

        //移除缓存
        //缓存
        List<SysHandle> handles= UrlArryListUtil.getInstance().getSysHandles();
        for(Long id : ids){
            int result = this.getHandlsListIndexById(handles ,id);
            if(result >= 0 )
                handles.remove(result);
        }

        return count;
    }

    /**
     * 获取下标
     * @param handles
     * @param sysHandle
     * @return
     */
    private   int  getHandlsListIndex( List<SysHandle> handles, SysHandle sysHandle){
       return this.getHandlsListIndexById(handles ,sysHandle.getId());
    }

    private synchronized int getHandlsListIndexById(List<SysHandle> handles, Long id){
        for(int i = 0 ; i<handles.size();i++ )
            if(handles.get(i).getId() == id)
                return i;
        return  -1;
    }

}