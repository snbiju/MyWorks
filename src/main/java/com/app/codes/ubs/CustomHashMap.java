package com.app.codes.ubs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private List<LinkedList<KeyValuePair<K, V>>> buckets;
    private int size;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets.get(index);

        for (KeyValuePair<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new KeyValuePair<>(key, value));
        size++;

        if ((double) size / buckets.size() > LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets.get(index);

        for (KeyValuePair<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets.get(index);

        for (KeyValuePair<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % buckets.size();
    }

    private void resize() {
        int newCapacity = buckets.size() * 2;
        List<LinkedList<KeyValuePair<K, V>>> newBuckets = new ArrayList<>(newCapacity);

        for (int i = 0; i < newCapacity; i++) {
            newBuckets.add(new LinkedList<>());
        }

        for (LinkedList<KeyValuePair<K, V>> bucket : buckets) {
            for (KeyValuePair<K, V> entry : bucket) {
                int newIndex = entry.key.hashCode() % newCapacity;
                newBuckets.get(newIndex).add(entry);
            }
        }

        buckets = newBuckets;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size());
        System.out.println("Value for key 'two': " + map.get("two"));

        map.remove("two");
        System.out.println("Size after removing 'two': " + map.size());
        System.out.println("Value for key 'two' after removal: " + map.get("two"));
    }
}

