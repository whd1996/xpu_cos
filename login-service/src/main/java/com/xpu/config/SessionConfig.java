package com.xpu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author whd
 * @Description: 开启自动化配置 Spring Session 使用 Redis 作为数据源
 * maxInactiveIntervalInSeconds=30 30秒后过期
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400)
@Configuration
public class SessionConfig {

    @Bean
    public static ConfigureRedisAction configureRedisAction(){
        return ConfigureRedisAction.NO_OP;
    }
}
