package com.sara.security.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class RequestResponseFilter implements Filter {

    private static final Log logger = LogFactory.getLog(RequestResponseFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if(logger.isDebugEnabled()){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            logger.debug("Request URI :" + request.getRequestURI() + ",Authorization Headers :" + request.getHeader("Authorization") );
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    logger.debug("Cookie :{"+cookie.getName()+","+cookie.getValue()+"}");
                }
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
