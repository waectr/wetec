package com.waectr.wetec;

import com.waectr.wetec.controller.viewobject.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class WetecApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //字符串
//    @Autowired
//    RedisTemplate redisTemplate; //操作对象

    @Autowired
    RedisTemplate<Object,UserVO> userVORedisTemplate;

    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForValue();//操作字符串
//        stringRedisTemplate.opsForHash(); //操作哈希
//        stringRedisTemplate.opsForValue().append("msg","hello");
        //自己转json
        UserVO userVO = new UserVO();
        userVO.setUserName("zhaolei hanhan");
        userVORedisTemplate.opsForValue().set("user1",userVO);
    }

}
