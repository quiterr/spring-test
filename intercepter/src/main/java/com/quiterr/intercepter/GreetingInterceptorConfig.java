package com.quiterr.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.invoke.MethodHandles;


@Component
public class GreetingInterceptorConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private GreetingInterceptor greetingInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        logger.info("GreetingInterceptorConfig::addInterceptors is called");

        // 多个拦截器组成一个拦截器链
        registry.addInterceptor(greetingInterceptor).addPathPatterns("/**");
    }
}