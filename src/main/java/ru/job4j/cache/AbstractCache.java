package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        System.out.println("Данные загружены в кеш.");
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        result = result == null ? load(key) : result;
        return result;
    }

    protected abstract V load(K key);
}
