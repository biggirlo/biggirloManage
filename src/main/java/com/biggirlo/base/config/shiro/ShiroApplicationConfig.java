/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.shiro;

import com.biggirlo.base.util.YamlLoadUtil;
import org.apache.log4j.Logger;
import org.springframework.core.env.PropertySource;

/**
 *  shiro配置文件
 * @author 王雁欣
 * create on 2017/11/23 2:11 
 */
public class ShiroApplicationConfig {
    Logger logg= Logger.getLogger(ShiroApplicationConfig.class);

    private ShiroApplicationConfig(){
        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");
        logg.info("读取application.ymlcorsConfig配置");

        this.login = propertySource.getProperty("shiro.url.login").toString();
        logg.info("登录 login url:" + this.login);

        this.forbidden = propertySource.getProperty("shiro.url.forbidden").toString();
        logg.info("403 forbidden url:" + this.forbidden);

        this.logout = propertySource.getProperty("shiro.url.logout").toString();
        logg.info("退出登录 logout url:" + this.logout);

        this.unLogin = propertySource.getProperty("shiro.url.unLogin").toString();
        logg.info("未登录 unLogin url:" + this.unLogin);

        this.index = propertySource.getProperty("shiro.url.index").toString();
        logg.info("主页 index url:" + this.index);

        this.unauthorized = propertySource.getProperty("shiro.url.unauthorized").toString();
        logg.info("未授权 unauthorized url:" + this.unauthorized);
    }

    public static synchronized  ShiroApplicationConfig getInstance() {
        if(shiroApplicationConfig == null)
            shiroApplicationConfig = new ShiroApplicationConfig();
        return shiroApplicationConfig;
    }

    private static ShiroApplicationConfig shiroApplicationConfig = null;

    private String login;

    private String forbidden;

    private String logout;

    private String unLogin;

    private String index;

    private String unauthorized;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getForbidden() {
        return forbidden;
    }

    public void setForbidden(String forbidden) {
        this.forbidden = forbidden;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public String getUnLogin() {
        return unLogin;
    }

    public void setUnLogin(String unLogin) {
        this.unLogin = unLogin;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getUnauthorized() {
        return unauthorized;
    }

    public void setUnauthorized(String unauthorized) {
        this.unauthorized = unauthorized;
    }
}
