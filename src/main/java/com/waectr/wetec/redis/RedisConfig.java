package com.waectr.wetec.redis;

import com.waectr.wetec.controller.viewobject.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object,UserVO> uservoredisTemplate(
        RedisConnectionFactory redisConnectionFactory
    )throws UnknownHostException {
        RedisTemplate<Object,UserVO> template=new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<UserVO> serializer = new Jackson2JsonRedisSerializer<UserVO>(UserVO.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
}
