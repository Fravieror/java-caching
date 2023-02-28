package com.example.cache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineCache {

    private Cache<String, String> cache;

    // Create a cache using Caffeine
    public CaffeineCache() {
        cache = Caffeine.newBuilder()
                .maximumSize(100)
                .build();
    }

    // Add an entry to the cache
    public void put(String key, String value) {
        cache.put(key, value);
    }

    // Retrieve an entry from the cache
    public String get(String key) {
        return cache.getIfPresent(key);
    }

    // Remove an entry from the cache
    public void invalidate(String key) {
        cache.invalidate(key);
    }
}
