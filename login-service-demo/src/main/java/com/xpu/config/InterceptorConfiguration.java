package com.xpu.config;

import com.xpu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
//登录拦截器配置
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	@Resource
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//List<String> addPathList = null;
		List<String> excludePathList = null;
		// 登录拦截器
		InterceptorRegistration login = registry
				.addInterceptor(this.loginInterceptor);
		// 设置拦截的路径
		login.addPathPatterns("/*/*");
		// 设置例外的路径
		excludePathList = new ArrayList<>();
		excludePathList.add("/userDemo/login");
		excludePathList.add("/login");
		excludePathList.add("/index");
		excludePathList.add("/");
		excludePathList.add("/toLogin");
		excludePathList.add("/user/loginByAnnotation");
		excludePathList.add("/v2/api-docs-ext");
		excludePathList.add("/userDemo/foundPwd");
		excludePathList.add("/userDemo/logout");
		excludePathList.add("/userDemo/register");
		//excludePathList.add("/user/listUserRole");//测试用
		excludePathList.add("/css/**");
		excludePathList.add("/images/**");
		excludePathList.add("/js/**");
		excludePathList.add("/res/**");
		excludePathList.add("/myplugs/**");
		login.excludePathPatterns(excludePathList);
    }
	
	@Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/static/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/static/admin/images**").addResourceLocations("classpath:/static/admin/images");
		registry.addResourceHandler("/static/admin/js/**").addResourceLocations("classpath:/static/admin/js");
		registry.addResourceHandler("/static/admin/myplugs/**").addResourceLocations("classpath:/static/admin/myplugs/");
		registry.addResourceHandler("/static/admin/res/css/**").addResourceLocations("classpath:/static/admin/res/css/");
		registry.addResourceHandler("/static/admin/res/layui/css/**").addResourceLocations("classpath:/static/admin/res/layui/css/");
		registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");

		System.out.println("---------------------------");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
