package com.app.test.tesco;

import java.util.LinkedList;

class MyHashMap<K, V> {
    // Define an array of buckets (linked lists) to hold key-value pairs
    private LinkedList<Entry<K, V>>[] buckets;
    // Define the initial capacity of the HashMap
    private static final int INITIAL_CAPACITY = 16;
    // Define a load factor for resizing the array (optional)
    private static final float LOAD_FACTOR = 0.75f;
    // Define the current size of the HashMap
    private int size;

    // Entry class to hold key-value pairs
    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the HashMap with the specified capacity
    public MyHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Hash function to calculate the hash code for a given key
    private int hash(K key) {
        return key.hashCode() % buckets.length;
    }

    // Method to insert a key-value pair into the HashMap
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found, update the value
                entry.value = value;
                return;
            }
        }

        // If the key doesn't exist, add a new entry to the bucket
        bucket.add(new Entry<>(key, value));
        size++;

        // Optional: Resize the array if the load factor is exceeded
        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }
    }

    // Method to retrieve the value associated with a given key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Iterate through the bucket to find the key
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found, return the value
                return entry.value;
            }
        }
        // Key not found, return null
        return null;
    }

    // Method to remove a key-value pair from the HashMap
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Iterate through the bucket to find the key
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found, remove the entry from the bucket
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    // Method to resize the array of buckets when necessary
    private void resize() {
        // Double the capacity of the array
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[buckets.length * 2];
        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new LinkedList<>();
        }

        // Rehash all entries and move them to the new buckets
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Entry<K, V>> bucket = buckets[i];
            for (Entry<K, V> entry : bucket) {
                int newIndex = entry.key.hashCode() % newBuckets.length;
                newBuckets[newIndex].add(entry);
            }
        }

        // Update the buckets array
        buckets = newBuckets;
    }

    // Method to return the current size of the HashMap
    public int size() {
        return size;
    }
}

