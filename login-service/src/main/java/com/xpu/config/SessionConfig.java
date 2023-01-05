package com.xpu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//config配置，设置跨域子域session共享，redis格式设置为json
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
   /* @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION");
        serializer.setDomainName(".");
        return serializer;
    }
    }*/
// 这个springSessionDefaultRedisSerializer很重要，没有这个bean就是使用sdk默认的序列化，必须要实现Seralizeble接口

}
