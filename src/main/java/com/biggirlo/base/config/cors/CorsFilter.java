/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.cors;

import com.biggirlo.base.util.RegExp;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 解决跨域问题
 * @author 王雁欣
 * create on 2017/11/11 4:19 
 */
@Component
public class CorsFilter implements Filter {

    Logger logg= Logger.getLogger(CorsFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = WebUtils.toHttp(res);
        HttpServletRequest httpRequest = WebUtils.toHttp(req);
        String a = httpRequest.getHeader( CorsConfig.getInstance().getClientHostPortName());
        //httpResponse.setHeader("Access-Control-Allow-Origin",  httpRequest.getHeader( CorsConfig.getInstance().getClientHostPortName()));
        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            httpResponse.setHeader("Access-Control-Allow-Origin",  "*");
        }else if(Arrays.asList( CorsConfig.getInstance().getAccessControlAllowOrigin()).contains(httpRequest.getHeader( CorsConfig.getInstance().getClientHostPortName())))
            httpResponse.setHeader("Access-Control-Allow-Origin",   httpRequest.getHeader( CorsConfig.getInstance().getClientHostPortName()));
        httpResponse.setHeader("Access-Control-Allow-Methods", CorsConfig.getInstance().getAccessControlAllowMethods());
        httpResponse.setHeader("Access-Control-Max-Age", CorsConfig.getInstance().getAccessControlMaxAge());
        httpResponse.setHeader("Access-Control-Allow-Headers", CorsConfig.getInstance().getAccessControlAllowHeaders());
        logg.info("调用跨域处理过滤器");
        chain.doFilter(httpRequest, httpResponse);
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}