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
import java.util.Date;
import java.util.List;

import com.biggirlo.base.service.BaseService;
import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.jopo.search.MenuRoleSearch;
import com.biggirlo.system.mapper.SysMenuMapper;
import com.biggirlo.system.model.SysUserRole;
import com.biggirlo.system.util.UserLoginUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biggirlo.system.model.SysMenu;
import com.biggirlo.system.jopo.jstree.TreeNode;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("sysMenuService")
public class SysMenuService extends BaseService<SysMenu, Long> {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 获取所有的菜单 并生成树结构（用于菜单展示）
     * @return
     */
    public List<SysMenu> getTreeList() throws Exception{

        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        List<SysMenu> treeMenus = (List<SysMenu>) subject.getSession().getAttribute(UserLoginUtils.LOGIN_USER_MENUS_NAME);
        if(treeMenus == null){
            treeMenus = new ArrayList<>();
            //根据角色获取菜单
            List<SysUserRole> roles= (List<SysUserRole>) subject.getSession().getAttribute(UserLoginUtils.LOGIN_USER_ROLES_NAME);
            //设置查询条件
            MenuRoleSearch menuSearch = new MenuRoleSearch();
            //设置类型为菜单类型
            menuSearch.setMenuType(TreeNode.MENU);
            menuSearch.setRoles(roles);
            List<SysMenu> allMenus = sysMenuMapper.selectByRolesAuth(menuSearch);
            for(SysMenu menu: allMenus)
                //一级菜单的父级id为0
                if(menu.getParentId() == 0)
                    treeMenus.add(addChileMenu(menu,allMenus));
            //存入session
            subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_MENUS_NAME,treeMenus);
        }
        return treeMenus;
    }

    /**
     * 递归获取树结构菜单
     * @param parentMenu
     * @return
     */
    public SysMenu addChileMenu(SysMenu parentMenu,List<SysMenu> allMenus){
        for(SysMenu menu: allMenus)
            if(menu.getParentId() == parentMenu.getId())
                parentMenu.getMenus().add(addChileMenu(menu,allMenus));
        return parentMenu;
    }

    /**
     * 菜单树形结构（包含所有菜单结构）
     */
    public List<TreeNode> getJsTreeList() {
        List<SysMenu> treeMenus = new ArrayList<>();
        //设置查询条件
        List<SysMenu> allMenus = selectAll();
        List<TreeNode> nodes = new ArrayList<>();
        //设置根节点
        TreeNode root = new TreeNode();
        root.setId("0");
        root.setText("菜单管理");
        root.setParent("#");
        nodes.add(root);

        for(SysMenu menu : allMenus){
            TreeNode node = new TreeNode();
            node.setId(menu.getId().toString());
            node.setText(menu.getMenuName());
            node.setParent(menu.getParentId() == null?"0":menu.getParentId().toString());
            node.setIcon(menu.getType() == TreeNode.INTERFACE ? "fa fa-briefcase icon-state-success": null);
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * 保存
     * @param menu
     * @return
     */
    public Object save(SysMenu menu) {
        Restult rs ;
        SysMenu menuTemp = new SysMenu();
        menuTemp.setMenuCode(menu.getMenuCode());
        menuTemp = selectOne(menuTemp);
        if(menu.getId() != null && (menuTemp == null || menuTemp.getId() ==  menu.getId()) ) {
            menu.setUpdateTime(new Date());
            menu.setUpdateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, update(menu));
        }else if (menu.getId() == null && menuTemp == null) {
            menu.setCreateTime(new Date());
            menu.setCreateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, insert(menu));
        } else
            rs = new Restult(Code.REPEAT_KEYWORK.value(),"重复的菜单编码");

        return rs;
    }
}