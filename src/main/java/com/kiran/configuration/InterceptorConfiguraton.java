package com.kiran.configuration;

import com.kiran.interceptor.AuthenticatingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguraton implements WebMvcConfigurer {

    private final AuthenticatingInterceptor authenticatingInterceptor;

    public InterceptorConfiguraton(AuthenticatingInterceptor authenticatingInterceptor){
        this.authenticatingInterceptor = authenticatingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticatingInterceptor)
                .excludePathPatterns("/student/");
    }
}
