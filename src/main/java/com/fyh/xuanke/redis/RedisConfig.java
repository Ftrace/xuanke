package com.fyh.xuanke.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
@EnableAutoConfiguration
public class RedisConfig {
    /**
     * 注入 RedisConnectionFactory
     */
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * 实例化RedisTemplate对象
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> mainRedisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置数据存入redis的序列化方式
     * @param redisTemplate
     * @param redisConnectionFactory
     */
    public void initRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory
            redisConnectionFactory){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
// redisTemplate.setStringSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
    }


    /**
     * 实例化HashOperations对象，可以使用Hash操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object>
                                                                         redisTemplate){
        return redisTemplate.opsForHash();
    }

    /**
     * 实例化ListOperations对象，可以使用List操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForList();
    }

    /**
     * 实例化SetOperations对象，可以使用Set操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForSet();
    }

    /**
     * 实例化ValueOperations对象，可以使用string类型操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForValue();
    }


    /**
     * 实例化ZSetOperations对象，可以使用ZSet操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForZSet();
    }
}

