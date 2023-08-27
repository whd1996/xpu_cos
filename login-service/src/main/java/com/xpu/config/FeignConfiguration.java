package com.xpu.config;

import com.google.common.collect.Lists;
import feign.Logger;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * description  实现feign分布式会话一致
 * @author whd
 * @date 2023/8/27 18:33
 * @version 1.0.0
 */
@Configuration
@Slf4j
public class FeignConfiguration {

    public final static String HEADER_CALLER = "cloud_caller";

    public final static String COOKIE_COOKIE_NAME = "cookie";
    public final static String SESSIONID_COOKIE_NAME = "SESSION";
    // 对系统中允许后向传递的头进行控制
    private static List<String> disallowhHeaderNames = Lists.newArrayList(
            "cache-control"
            , "origin"
            , "upgrade-insecure-requests"
            , "user-agent"
            , "referer"
            , "accept"
            , "accept-language"
            , "connection"
    );
    @Value("${spring.application.name}")
    String application;

    @Bean
    public RequestInterceptor requestHeaderInterceptor() {
        return requestTemplate -> {
            //记录调用方信息
            requestTemplate.header(HEADER_CALLER, application);
            if (RequestContextHolder.getRequestAttributes() == null) {
                return;
            }
            // 注意子线程问题(RequestContextHolder 内部使用的是ThreadLocal)
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            // 当前请求携带的header
            Enumeration<String> headerNames = request.getHeaderNames();
            // 已经存在feign的requestTemplate的header
            Map<String, Collection<String>> headers = requestTemplate.headers();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    boolean exists = false; // 避免重复header往后传播，如content-type传播会影响后续body解析
                    for (String th : headers.keySet()) {
                        if (name.equalsIgnoreCase(th)) {// 忽略大小写
                            exists = true;
                            break;
                        }
                    }
                    if (!exists && !disallowhHeaderNames.contains(name.toLowerCase())) {
                        requestTemplate.header(name, Collections.list(request.getHeaders(name)));
                    }
                }
            }
        };
    }

    private String sessionId() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request.getSession().getId();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}