package br.com.joelf.domain.port;

public interface CacheRepository<K extends String, V> {
    V get(K key);
    void set(K key, V value);
    void delete(K key);
}
