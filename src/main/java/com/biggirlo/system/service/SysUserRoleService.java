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


import com.biggirlo.base.service.BaseService;
import com.biggirlo.system.jopo.parame.UserRolePalame;
import com.biggirlo.system.util.UserLoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biggirlo.system.model.SysUserRole;
import com.biggirlo.system.mapper.SysUserRoleMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("sysUserRoleService")
public class SysUserRoleService extends  BaseService<SysUserRole,Long>{

    @Autowired
    private SysUserRoleMapper mapper;

    /**
     * 根据条件获取用户列表
     * @param
     * @return
     */
    public Object selectUsersByRole(SysUserRole sysUserRole) {
        return mapper.selectUsersByRole(sysUserRole);
    }

    /**
     * 保存
     * @param palame
     */
    public Object saveUserRoles(UserRolePalame palame) {
        SysUserRole sysUserRoleSearch = new SysUserRole();
        Long roleId = palame.getRoleId();
        if(roleId == null)
            throw new NullPointerException("角色id不能为空");
        sysUserRoleSearch.setRoleId(palame.getRoleId());
        List<SysUserRole> list = select(sysUserRoleSearch);
        //插入数据
        List<SysUserRole> insertData = new ArrayList<>();
        for(Long userId : palame.getUserIds()){
            if(!this.isHasObj(userId,list)){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                //当前登录人
                sysUserRole.setCreateTime(new Date());
                sysUserRole.setCreateBy(UserLoginUtils.getCurrentUserId());
                insertData.add(sysUserRole);
            }
        }
        int inserCount =  insertList(insertData);
        int deleteCount = deleteObjs((SysUserRole[]) list.toArray(new SysUserRole[list.size()]));
        return inserCount + deleteCount;
    }

    /**
     * 判断是否含有用户id
     * @param userId
     * @param datas
     * @return
     */
    private boolean isHasObj(Long userId ,List<SysUserRole> datas){
        for(SysUserRole sysUserRole:datas)
            if(sysUserRole.getUserId() == userId){
                datas.remove(sysUserRole);
                return true;
            }
        return false;
    }
}