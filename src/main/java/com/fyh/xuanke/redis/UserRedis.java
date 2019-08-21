package com.fyh.xuanke.redis;

import com.fyh.xuanke.model.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;


@Repository
public class UserRedis extends BaseRedis<User> {

    private static final String REDIS_KEY="com.fyh.xuanke.redis.UserRedis";
    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }

//    public void add(String key, Long time, User user){
//        Gson gson = new Gson();
//        redisTemplate.opsForValue().set(key, gson.toJson(user), time, TimeUnit.SECONDS);
//    }
}
