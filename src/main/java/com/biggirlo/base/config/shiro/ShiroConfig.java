/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.shiro;


import com.biggirlo.base.config.shiro.filter.JWTOrAuthenticationFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author 王雁欣
 * create on 2017/10/17 21:44 
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //shoir application.yml配置单例对象
        ShiroApplicationConfig shiroApplicationConfig = ShiroApplicationConfig.getInstance();

        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put(shiroApplicationConfig.getLogin(), "anon");
        filterChainDefinitionMap.put(shiroApplicationConfig.getLogout(), "anon");
        filterChainDefinitionMap.put(shiroApplicationConfig.getForbidden(), "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        //filterChainDefinitionMap.put(shiroApplicationConfig.getLogout(), "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        //filterChainDefinitionMap.put("/**", "urlAuth");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(shiroApplicationConfig.getUnLogin());
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl(shiroApplicationConfig.getIndex());

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl(shiroApplicationConfig.getUnauthorized());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //自定义过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new JWTOrAuthenticationFilter());
        //filters.put("urlAuth",new AuthenUrlFillter());
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setSessionManager(new SessionManager());
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
}
