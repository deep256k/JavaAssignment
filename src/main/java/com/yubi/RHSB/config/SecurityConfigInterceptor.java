package com.yubi.RHSB.config;


import com.yubi.RHSB.interceptor.CustomAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
@EnableWebMvc
public class SecurityConfigInterceptor implements WebMvcConfigurer {
    @Autowired
    CustomAuthenticationInterceptor customAuthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customAuthenticationInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/authenticate");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}