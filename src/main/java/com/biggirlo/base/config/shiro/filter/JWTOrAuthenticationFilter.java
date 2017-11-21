/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.shiro.filter;

import com.biggirlo.base.config.cors.CorsConfig;
import com.biggirlo.base.util.YamlLoadUtil;
import com.biggirlo.system.model.SysMenu;
import com.biggirlo.system.util.UserLoginUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2017/11/12 4:41 
 */
public class JWTOrAuthenticationFilter extends FormAuthenticationFilter {

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
        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        List<SysMenu> menus = (List<SysMenu>) subject.getSession().getAttribute(UserLoginUtils.LOGIN_USER_MENUS_NAME);
        System.out.print(httpRequest.getRequestURL());

        return super.preHandle(request, response);

    }

}
