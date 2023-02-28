package com.example.cache;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CaffeineCacheTests {
    private CaffeineCache cache;

    @BeforeAll
    public void setup() {
        cache = new CaffeineCache();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
    }

    @Test
    public void testPutAndGet() {
        cache.put("key3", "value3");
        assertEquals("value3", cache.get("key3"));
    }

    @Test
    public void testInvalidate() {
        cache.invalidate("key1");
        assertNull(cache.get("key1"));
    }
}
