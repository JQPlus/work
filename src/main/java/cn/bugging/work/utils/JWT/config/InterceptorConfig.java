package cn.bugging.work.utils.JWT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.bugging.work.utils.JWT.interceptor.AuthenticationInterceptor;

//在配置类上添加了注解@Configuration，标明了该类是一个配置类并且会将该类作为一个SpringBean添加到IOC容器内
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	/**
	 * @author HuangJq @Date 2019年5月6日下午5:40:07
	 * @Description
	 * 
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}