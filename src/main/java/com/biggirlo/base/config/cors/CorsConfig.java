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

        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");
        logg.info("读取application.ymlcorsConfig配置");
        this.tokenheaderName = propertySource.getProperty("shiro.cors.tokenheaderName").toString();
        logg.info("token-header-name:" + this.tokenheaderName);
        this.clientHostPortName = propertySource.getProperty("shiro.cors.clientHostPortName").toString();
        logg.info("access-control-allow-origin:" + this.clientHostPortName);
        this.accessControlAllowMethods = propertySource.getProperty("shiro.cors.accessControlAllowMethods").toString();
        logg.info("access-control-allow-methods:" + this.accessControlAllowMethods);
        this.accessControlAllowHeaders = propertySource.getProperty("shiro.cors.accessControlAllowHeaders").toString();
        logg.info("access-control-allow-headers:" + this.accessControlAllowHeaders);
        this.accessControlMaxAge = propertySource.getProperty("shiro.cors.accessControlMaxAge").toString();
        logg.info("access-control-maxAge:" + this.accessControlMaxAge);
        this.accessControlAllowOrigin = propertySource.getProperty("shiro.cors.accessControlAllowOrigin").toString();
        logg.info("access-control-allow-origin:" + this.accessControlAllowOrigin);
    }
    private static CorsConfig corsConfig= new CorsConfig();
    //静态工厂方法
    public static synchronized  CorsConfig getInstance() {
        return corsConfig;
    }

    //存放token的表头名称
    private String tokenheaderName;

    //存放客户端地址的表头
    private String clientHostPortName;

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

    public String getClientHostPortName() {
        return clientHostPortName;
    }

    public void setClientHostPortName(String clientHostPortName) {
        this.clientHostPortName = clientHostPortName;
    }
}
