package com.huang.chatgpt_vits.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Value("${vits.apiPath}")
    private String apiPath;
    @Value("${vits.localPath}")
    private String localPath;

    //视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/home.html").setViewName("home");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/system.html").setViewName("system");
        WebMvcConfigurer.super.addViewControllers(registry);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //wav文件保存路径
        registry.addResourceHandler(apiPath).addResourceLocations("file:" + localPath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


}
