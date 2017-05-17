package com.quiterr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Huangchen on 2017/5/17.
 */
@Component
public class RedisService {

    private StringRedisTemplate template;

    @Autowired
    public RedisService(StringRedisTemplate template) {
        this.template = template;
    }

    public void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public String get(String key) {
        return template.opsForValue().get(key);
    }
}
