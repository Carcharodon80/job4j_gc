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
        V result;
        if (cache.containsKey(key) && cache.get(key).get() != null) {
            System.out.println("Данные получены из кеша");
            result = cache.get(key).get();
        } else {
            result = load(key);
        }
        return result;
    }

    protected abstract V load(K key);
}
