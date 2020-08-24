package com.baizhi.config;

import com.baizhi.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration//配置相关的用这个 @Component也可以被扫描到
public class InterceptorConfig implements WebMvcConfigurer {
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())//要添加的拦截器类
        .addPathPatterns("/user/test")//要拦截的路径
        .excludePathPatterns("/user/login");//排除user相关的路径
       /* .addPathPatterns("/**")//要拦截的路径
                .excludePathPatterns("/user/**");//排除user相关的路径*/
    }
}
