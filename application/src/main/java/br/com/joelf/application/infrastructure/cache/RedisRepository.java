package br.com.joelf.application.infrastructure.cache;

import br.com.joelf.domain.port.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class RedisRepository<K extends String, V> implements CacheRepository<K, V> {

    private final RedisTemplate<K, V> redisTemplate;
    private final String timeToLive;

    private static final TimeUnit REDIS_TIME_UNIT = TimeUnit.DAYS;

    @Override
    public V get(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key, value, Long.parseLong(timeToLive), REDIS_TIME_UNIT);
    }
}
