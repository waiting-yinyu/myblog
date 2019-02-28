package com.alvin.springbootvue.service;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年2月28日
*/
@Service
public class RedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    public void set(String key, Object value) {
        //更改在redis里面查看key编码问题
        RedisSerializer<String> redisSerializer = new  StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String, Object> vo =  redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public Object get(String key) {
        ValueOperations<String, Object> vo =  redisTemplate.opsForValue();
        return vo.get(key);
    }
}
