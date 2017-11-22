/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.shiro.filter;

import com.biggirlo.base.config.cors.CorsConfig;
import com.biggirlo.base.config.shiro.ShiroApplicationConfig;
import com.biggirlo.base.config.shiro.authenurl.URL;
import com.biggirlo.base.config.shiro.authenurl.UrlArryListUtil;
import com.biggirlo.base.util.YamlLoadUtil;
import com.biggirlo.system.model.SysMenu;
import com.biggirlo.system.util.UserLoginUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2017/11/12 4:41 
 */
public class JWTOrAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    private UrlArryListUtil urlArryListUtil;

    private static final Logger log = LoggerFactory.getLogger(FormAuthenticationFilter.class);

    public JWTOrAuthenticationFilter( ){

    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpResponse.setHeader("Access-control-Allow-Origin", httpRequest.getHeader( CorsConfig.getInstance().getClientHostPortName()));
            httpResponse.setHeader("Access-Control-Allow-Methods", CorsConfig.getInstance().getAccessControlAllowMethods());
            httpResponse.setHeader("Access-Control-Allow-Headers", CorsConfig.getInstance().getAccessControlAllowHeaders());
            httpResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
       /* Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        List<SysMenu> menus = (List<SysMenu>) subject.getSession().getAttribute(UserLoginUtils.LOGIN_USER_MENUS_NAME);
        System.out.print(httpRequest.getRequestURL());*/

        boolean isLogin = super.preHandle(request, response);
        //为正值的时候判断是否
        if(isLogin){
            this.isForbidden(request,response);
        }
        return isLogin;
    }


    /**
     * 判断是否有访问权限
     * @return
     */
    private void isForbidden(ServletRequest request,
                             ServletResponse response) throws IOException {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String url = httpServletRequest.getServletPath().toString();
        //判断是否有访问权限
        if(this.isInAuthnUrls(url)){
            //无权限url
            String forbiddenUrl = ShiroApplicationConfig.getInstance().getForbidden();
            forbiddenUrl += "&loginType=json";
            log.trace("forbiddenUrl" + forbiddenUrl);
            WebUtils.issueRedirect(request, response, forbiddenUrl);
        }
    }

    /**
     * 是否在需要控制权限的url里面
     * @param url
     * @return
     */
    private boolean isInAuthnUrls(String url){
        List<URL> urls = UrlArryListUtil.getInstance().getUrls();
        for(URL urltemp : urls){
            if(urltemp.getUrl() != null && urltemp.getUrl().equals(url))
                return true;
        }
        return false;
    }
}
