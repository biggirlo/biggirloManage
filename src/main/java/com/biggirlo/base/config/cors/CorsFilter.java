/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.cors;

import com.biggirlo.base.util.RegExp;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决跨域问题
 * @author 王雁欣
 * create on 2017/11/11 4:19 
 */
@Component
@Order(3)
public class CorsFilter implements Filter {

    Logger logg= Logger.getLogger(CorsFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
       /* HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:10100");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE,OPTIONS");
        response.setHeader("Access-Control-Request-Methods", "POST, GET, PUT, DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authentication,Origin, X-Requested-With, Content-Type,token,Accept,Authorization");
        response.setHeader("Access-Control-Request-Headers", "Authentication,Origin, X-Requested-With, Content-Type,token,Accept,Authorization");
        logg.info("调用跨域处理过滤器");
        chain.doFilter(req, res);*/

        HttpServletResponse httpResponse = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String uri = httpRequest.getRequestURI();
        StringBuffer url = httpRequest.getRequestURL();
        RegExp re = new RegExp();
        String origin = re.findString("^https?://[\\w-.]+(:\\d+)?",url.toString());

        httpResponse.setHeader("Access-Control-Allow-Origin",   CorsConfig.getInstance().getAccessControlAllowOrigin());
        httpResponse.setHeader("Access-Control-Allow-Methods", CorsConfig.getInstance().getAccessControlAllowMethods());
        httpResponse.setHeader("Access-Control-Max-Age", CorsConfig.getInstance().getAccessControlMaxAge());
        httpResponse.setHeader("Access-Control-Allow-Headers", CorsConfig.getInstance().getAccessControlAllowHeaders());
        logg.info("调用跨域处理过滤器");
        chain.doFilter(httpRequest, httpResponse);
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}