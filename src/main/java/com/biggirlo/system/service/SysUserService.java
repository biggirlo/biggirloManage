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
import com.biggirlo.base.util.DecriptUtil;
import com.biggirlo.base.util.Restult;
import com.biggirlo.system.jopo.LoginUser;
import com.biggirlo.system.mapper.SysUserMapper;
import com.biggirlo.system.mapper.SysUserRoleMapper;
import com.biggirlo.system.model.SysHandle;
import com.biggirlo.system.model.SysUserRole;
import com.biggirlo.system.util.UserLoginUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biggirlo.system.model.SysUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 系统用户表业务类
 * </pre>
 */
@Service("sysUserService")
public class SysUserService extends BaseService<SysUser, Long> {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysHandleService sysHandleService;

    /**
     * 保存编辑的数据
     * @param user
     * @return
     */
    public Object save(SysUser user) {
        Restult rs ;
        SysUser userTemp = new SysUser();
        userTemp.setUserCode(user.getUserCode());
        userTemp = selectOne(userTemp);
        if(user.getId() != null && (userTemp == null || userTemp.getId() ==  user.getId()) ) {
            user.setPassword(user.getPassword() == null?null:DecriptUtil.MD5(user.getPassword()));
            user.setUpdateTime(new Date());
            user.setUpdateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, update(user));
        }else if (user.getId() == null && userTemp == null) {
            //设置默认密码
            user.setPassword(user.getPassword() == null?DecriptUtil.MD5(UserLoginUtils.DEFAUTE_PASSWORD):DecriptUtil.MD5(user.getPassword()));
            user.setCreateTime(new Date());
            user.setCreateBy(UserLoginUtils.getCurrentUserId());
            rs = new Restult(Code.SUCCESS, insert(user));
         }
        else
            rs = new Restult(Code.REPEAT_KEYWORK.value(),"重复的菜单编码");

        return rs;
    }

    /**
     * 登录验证
     * @param user
     */
    public Restult login(SysUser user) {
        //判断是否为空
        if(user == null || user.getUserCode() == null || "".equals(user.getUserCode()) || user.getPassword() == null ||"".equals(user.getPassword()))
            return new Restult(Code.LOGIN_ERROR_UN_EXIST_NAME_PASSWORD);

        //查询
        SysUser userSearch = new SysUser();
        userSearch.setUserCode(user.getUserCode());
        userSearch.setPassword(DecriptUtil.MD5(user.getPassword()));
        userSearch.setIsAvailable(1);

        SysUser dataUser = selectOne(userSearch);
        if( dataUser == null )
            return new Restult(Code.LOGIN_ERROR_FALIE_NAME_PASSWORD);

        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken(userSearch.getUserCode(), userSearch.getPassword());

        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        subject.login(token); // 登陆
        //设置session对象
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(dataUser);
        loginUser.setLoginTime(new Date());
        //获取所有的角色
        SysUserRole sysUserRoleSearch = new SysUserRole();
        sysUserRoleSearch.setUserId(dataUser.getId());
        List<SysUserRole> userRoles = sysUserRoleService.select(sysUserRoleSearch);
        //获取所有操作权限的操作列表
        List<SysHandle> sysHandles = sysHandleService.getHandleByRoles(userRoles);

        //设置缓存
        subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_SESSION_NAME,loginUser);
        subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_ROLES_NAME,userRoles);
        subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_HANDLE_NAME,sysHandles);


        return new Restult(Code.SUCCESS,subject.getSession().getId());
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public Object deleteItems(Long[] ids) {
        int count = this.deletes(ids);

        //删除该用户拥有的角色关系
        List<SysUserRole> roles = new ArrayList<>();
        for(long id : ids){
            SysUserRole role = new SysUserRole();
            role.setUserId(id);
            roles.add(role);
        }
        count += sysUserRoleMapper.deleteList(roles);

        return count;
    }
}