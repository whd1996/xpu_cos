package com.xpu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//config配置，设置跨域子域session共享，redis格式设置为json
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
