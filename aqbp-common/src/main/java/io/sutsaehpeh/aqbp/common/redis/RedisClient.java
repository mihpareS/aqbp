package io.sutsaehpeh.aqbp.common.redis;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public RedisClient() {
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public <T> void set(String key, T value, Long timeOfSec) {
        if (ObjectUtil.isNotNull(timeOfSec) && timeOfSec > 0L) {
            this.redisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), timeOfSec);
        }
    }

    public <T> T get(String key, Class<T> valueClazz) {
        return getOpt(key, valueClazz).orElse(null);
    }

    public <T> T get(String key, TypeReference<T> typeReference) {
        return getOpt(key, typeReference).orElse(null);
    }

    public <T> List<T> getAsList(String key, Class<T> valueClazz) {
        return getOptAsList(key, valueClazz).orElse(new ArrayList<>());
    }

    public Boolean hasKey(String key) {
        return !ObjectUtil.isNull(key) && Boolean.TRUE.equals(this.redisTemplate.hasKey(key));
    }

    public void expire(String key, Long expireTimeOfSec) {
        if (ObjectUtil.isNotNull(key) && ObjectUtil.isNotNull(expireTimeOfSec)) {
            this.redisTemplate.expire(key, expireTimeOfSec, TimeUnit.SECONDS);
        }
    }

    public void delete(String key) {
        if (ObjectUtil.isNotNull(key)) {
            this.redisTemplate.delete(key);
        }
    }

    public Long increment(String key, Long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public Long increment(String key, Long delta, Long expireTimeOfSec) {
        Long longValueStr = redisTemplate.opsForValue().increment(key, delta);
        redisTemplate.expire(key, expireTimeOfSec, TimeUnit.SECONDS);
        return longValueStr;
    }

    public <T> Optional<T> getOpt(String key, Class<T> valueClazz) {
        String valueStr = (String) this.redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(valueStr).map(v -> JSONUtil.toBean(valueStr, valueClazz));
    }

    public <T> Optional<T> getOpt(String key, TypeReference<T> typeReference) {
        String valueStr = (String) this.redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(valueStr).map(v -> JSONUtil.toBean(valueStr, typeReference, false));
    }

    public <T> Optional<List<T>> getOptAsList(String key, Class<T> valueClazz) {
        String valueStr = (String) this.redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(valueStr).map(v -> JSONUtil.toList(valueStr, valueClazz));
    }
}
