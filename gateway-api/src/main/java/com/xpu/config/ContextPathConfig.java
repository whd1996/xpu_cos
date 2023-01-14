package com.xpu.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.WebFilter;

/**
 * 配置修改网关服务的 context-path 需要时使用 在yml中配置即可
 */
@Configuration
public class ContextPathConfig {
 
    @Bean
    @ConditionalOnProperty("server.servlet.context-path")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public WebFilter contextPathWebFilter(ServerProperties serverProperties){
        String contextPath = serverProperties.getServlet().getContextPath();
 
        return (serverWebExchange, webFilterChain) ->{
            ServerHttpRequest request = serverWebExchange.getRequest();
            String requestPath = request.getURI().getPath();
 
            if(requestPath.contains(contextPath)){
                String newPath = requestPath.replaceFirst(contextPath, "");
                ServerHttpRequest newRequest = request.mutate()
                                .path(newPath).build();
                return webFilterChain.filter(serverWebExchange.mutate()
                                .request(newRequest)
                                .build()
                );
            }else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        };
    }
}
