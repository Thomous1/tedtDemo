package com.bonc.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by 王小浪 on 2018/8/15.
 * desc :
 *      我们使用@EnableCaching注解来开启我们的项目支持缓存，
 *      我们在配置类内添加了方法cacheManager()，
 *      方法的返回值则是使用了我们的Redis缓存的管理器，
 *      SpringBoot项目启动时就会去找自定义配置的CacheManager对象并且自动应用到项目中。
 */
@Configuration
@EnableCaching
public class RedisConfiguration{
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        System.out.println("redis进来了");
        return  new RedisCacheManager(redisTemplate);
    }

}
