package com.waectr.wetec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class WetecApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //字符串
    @Autowired
    RedisTemplate redisTemplate; //操作对象
    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForValue();//操作字符串
//        stringRedisTemplate.opsForHash(); //操作哈希
        stringRedisTemplate.opsForValue().append("msg","hello");
    }

}
