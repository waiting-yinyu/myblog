package com.alvin.springbootvue.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年2月28日
*/

@Configuration
@EnableCaching // 开启缓存
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
	    return RedisCacheManager.create(connectionFactory);
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
}
