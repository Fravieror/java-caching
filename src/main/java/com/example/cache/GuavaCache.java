package com.example.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;

public class GuavaCache {
    private final LoadingCache<String, String> cache;
    public GuavaCache() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(100) // maximum number of entries in the cache
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        // this method will be called if the requested key is not already in the cache
                        // here you can put your code to fetch the value corresponding to the key
                        return fetchValueFromDatabase(key);
                    }
                });
    }

    public String get(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            // this exception will be thrown if the CacheLoader's load() method throws an exception
            throw new RuntimeException("Error fetching value for key " + key, e);
        }
    }

    // replace this method with your code to fetch the value corresponding to the key
    protected String fetchValueFromDatabase(String key) {
        // example implementation: just return the key as the value
        return key + "_value";
    }
}
