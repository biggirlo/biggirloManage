/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.shiro.authenurl;

/**
 *
 * @author 王雁欣
 * create on 2017/11/22 22:00 
 */
public class URL {

    /**
     * 编码
     */
    private String code;

    /**
     * url
     */
    private String url;

    /**
     * 是否启用 1：启用 2：停用
     */
    private Integer isAvailable;

    private String method;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
