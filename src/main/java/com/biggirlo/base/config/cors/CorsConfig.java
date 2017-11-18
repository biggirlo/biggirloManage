/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.cors;

import com.biggirlo.base.util.YamlLoadUtil;
import org.apache.log4j.Logger;
import org.springframework.core.env.PropertySource;

/**
 *
 * @author 王雁欣
 * create on 2017/11/12 11:59 
 */

public class CorsConfig {
    Logger logg= Logger.getLogger(CorsConfig.class);

    private CorsConfig() {
        logg.info("读取application.ymlcorsConfig配置");
        logg.info("token-header-name:" + this.tokenheaderName);
        logg.info("access-control-allow-methods:" + this.accessControlAllowMethods);
        logg.info("access-control-allow-headers:" + this.accessControlAllowHeaders);
        logg.info("access-control-maxAge:" + this.accessControlMaxAge);
        logg.info("access-control-allow-origin:" + this.accessControlAllowOrigin);
        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");
        this.tokenheaderName = propertySource.getProperty("shiro.tokenheaderName").toString();
        this.accessControlAllowMethods = propertySource.getProperty("shiro.accessControlAllowMethods").toString();
        this.accessControlAllowHeaders = propertySource.getProperty("shiro.accessControlAllowHeaders").toString();
        this.accessControlMaxAge = propertySource.getProperty("shiro.accessControlMaxAge").toString();
        this.accessControlAllowOrigin = propertySource.getProperty("shiro.accessControlAllowOrigin").toString();
    }
    private static CorsConfig corsConfig= new CorsConfig();
    //静态工厂方法
    public static synchronized  CorsConfig getInstance() {
        return corsConfig;
    }

    //存放token的表头名称
    private String tokenheaderName;

    private String accessControlAllowMethods;

    private String accessControlAllowHeaders;

    private String accessControlMaxAge;

    private String accessControlAllowOrigin;

    public String getTokenheaderName() {
        return tokenheaderName;
    }

    public void setTokenheaderName(String tokenheaderName) {
        this.tokenheaderName = tokenheaderName;
    }

    public String getAccessControlAllowMethods() {
        return accessControlAllowMethods;
    }

    public void setAccessControlAllowMethods(String accessControlAllowMethods) {
        this.accessControlAllowMethods = accessControlAllowMethods;
    }

    public String getAccessControlAllowHeaders() {
        return accessControlAllowHeaders;
    }

    public void setAccessControlAllowHeaders(String accessControlAllowHeaders) {
        this.accessControlAllowHeaders = accessControlAllowHeaders;
    }

    public String getAccessControlMaxAge() {
        return accessControlMaxAge;
    }

    public void setAccessControlMaxAge(String accessControlMaxAge) {
        this.accessControlMaxAge = accessControlMaxAge;
    }

    public String getAccessControlAllowOrigin() {
        return accessControlAllowOrigin;
    }

    public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
        this.accessControlAllowOrigin = accessControlAllowOrigin;
    }
}
