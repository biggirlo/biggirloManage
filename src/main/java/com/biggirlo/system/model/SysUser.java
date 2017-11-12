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

package com.biggirlo.system.model;

import java.sql.Timestamp;

import com.biggirlo.base.model.BaseModel;

import javax.persistence.Table;

/**
 * <pre>
 * 系统用户表实体类
 * 数据库表名称：bs_sys_user
 * </pre>
 */
@Table(name = "BS_SYS_USER")
public class SysUser extends BaseModel{
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * 数据库字段信息:user_code VARCHAR(50)
     */
    private String userCode;

    /**
     * 
     * 
     * 数据库字段信息:name VARCHAR(100)
     */
    private String name;

    /**
     *
     *
     * 数据库字段信息:password VARCHAR(100)
     */
    private String password;

    /**
     * 
     * 
     * 数据库字段信息:moblie VARCHAR(11)
     */
    private String moblie;

    /**
     * 
     * 
     * 数据库字段信息:email VARCHAR(200)
     */
    private String email;

    /**
     * 
     * 
     * 数据库字段信息:remark VARCHAR(1000)
     */
    private String remark;

    /**
     * 
     * 
     * 数据库字段信息:is_available TINYINT(3)
     */
    private Integer isAvailable;

    /**
     *
     *
     * 数据库字段信息:is_available TINYINT(3)
     */
    private String hardImg;


    public SysUser() {
    }	
    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
	
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    public String getMoblie() {
        return this.moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }
	
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
	
    public Integer getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHardImg() {
        return hardImg;
    }

    public void setHardImg(String hardImg) {
        this.hardImg = hardImg;
    }
}