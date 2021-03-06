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
import com.biggirlo.base.util.Code;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.mapper.SysUserRoleMapper;
import com.biggirlo.system.model.SysUserRole;
import com.biggirlo.system.util.UserLoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biggirlo.system.model.SysRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("sysRoleService")
public class SysRoleService extends BaseService<SysRole, Long> {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 保存数据
     * @param role
     * @return
     */
    public Object save(SysRole role) {
        Restult rs ;
        SysRole roleTemp = new SysRole();
        roleTemp.setRoleCode(role.getRoleCode());
        roleTemp = selectOne(roleTemp);
        if(role.getId() != null && (roleTemp == null || roleTemp.getId() ==  role.getId()) ) {
            role.setUpdateTime(new Date());
            role.setUpdateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, update(role));
        }else if (role.getId() == null && roleTemp == null) {
            role.setCreateTime(new Date());
            role.setCreateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, insert(role));
        }
        else
            rs = new Restult(Code.REPEAT_KEYWORK.value(),"重复的角色编码");

        return rs;
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    public Object deleteByIds(Long[] ids) {
        int count = this.deletes(ids);
        List<SysUserRole> roles = new ArrayList<>();
        //级联删除，删除用户-角色关系
        for(Long id :ids){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(id);
            roles.add(sysUserRole);
        }
        count += sysUserRoleMapper.deleteList(roles);
        return count;
    }
}