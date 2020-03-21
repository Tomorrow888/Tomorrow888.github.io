package com.qlu.restfulcrud.config;

import com.qlu.restfulcrud.component.LoginHandlerInterceptor;
import com.qlu.restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jiajinshuo
 * @create 2020-02-07 20:22
 */
//@Configuration
//public class MvcConfig extends WebMvcConfigurationSupport {
//
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/today").setViewName("success");
//    }
//
//
//}
    @Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //视图映射
        registry.addViewController("/tomorrow").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }
    //国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
    //注册拦截器
    public  void addInterceptors(InterceptorRegistry registry) {
        //登录拦截器
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
    }


}