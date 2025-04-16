package br.com.joelf.domain.port;

public interface CacheRepository<K, V> {
    V get(K key);
    void set(K key, V value);
}
