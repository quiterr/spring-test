package com.quiterr.intercepter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;


@Component
public class GreetingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("GreetingInterceptor::preHandle(...) is called");
        try {
            String appToken = request.getHeader("app-token");
            if (appToken != null&&!appToken.equals("")) {
                logger.info("app-token ok");
                return true;
            }else {
                response.setStatus(400);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"errCode\":\"400\",\"errMsg\":\"app-token must be set\"}");
                logger.info("app-token is null");
                return false;
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}