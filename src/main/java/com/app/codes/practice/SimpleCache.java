package com.app.codes.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache<K, V> {
    private final int maxSize;
    private final Map<K, V> cache;

    public SimpleCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new LinkedHashMap<K, V>(maxSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > SimpleCache.this.maxSize;
            }
        };
    }

    // Add or update an item in the cache
    public synchronized void put(K key, V value) {
        cache.put(key, value);
    }

    // Retrieve an item from the cache
    public synchronized V get(K key) {
        return cache.get(key);
    }

    // Remove an item from the cache
    public synchronized V remove(K key) {
        return cache.remove(key);
    }

    // Flush the entire cache
    public synchronized void flush() {
        cache.clear();
    }

    // Get the current size of the cache
    public synchronized int size() {
        return cache.size();
    }

    // Display the current contents of the cache
    public synchronized void display() {
        System.out.println("Cache contents:");
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SimpleCache<String, String> cache = new SimpleCache<>(3);

        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");

        cache.display();

        System.out.println("Get key '2': " + cache.get("2"));
        cache.display();

        cache.put("4", "four");
        cache.display();

        cache.remove("2");
        cache.display();

        cache.flush();
        cache.display();
    }
}

