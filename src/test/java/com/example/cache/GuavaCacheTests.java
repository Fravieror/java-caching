package com.example.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuavaCacheTests {
    @Test
    public void testGet() throws Exception {
        GuavaCache cache = new GuavaCache();

        // first call to get() will invoke fetchValueFromDatabase() and cache the result
        assertEquals("key_value", cache.get("key"));

        // second call to get() will return the cached result without invoking fetchValueFromDatabase()
        assertEquals("key_value", cache.get("key"));

        // third call to get() with a different key will invoke fetchValueFromDatabase() again
        assertEquals("key1_value", cache.get("key1"));
    }
}
