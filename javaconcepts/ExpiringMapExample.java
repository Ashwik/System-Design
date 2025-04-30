package javaconcepts;

import java.util.*;
import java.util.concurrent.*;

// Common class for storing value and expiration time
class ExpiringEntry<V> {
    V value;
    long expirationTime;

    ExpiringEntry(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }

    boolean isExpired(long currentTime) {
        return currentTime > expirationTime;
    }

    boolean isExpired() {
        return isExpired(System.currentTimeMillis());
    }
}

// Demand-Based Cleanup Implementation
class DemandBasedCleanupMap<K, V> {
    private final Map<K, ExpiringEntry<V>> map;

    public DemandBasedCleanupMap() {
        this.map = new ConcurrentHashMap<>();
    }

    public void put(K key, V value, long ttlMillis) {
        long expirationTime = System.currentTimeMillis() + ttlMillis;
        map.put(key, new ExpiringEntry<>(value, expirationTime));
    }

    public V get(K key) {
        cleanupExpiredEntries();
        ExpiringEntry<V> entry = map.get(key);
        return (entry == null || entry.isExpired()) ? null : entry.value;
    }

    public boolean containsKey(K key) {
        cleanupExpiredEntries();
        return map.containsKey(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    private void cleanupExpiredEntries() {
        long currentTime = System.currentTimeMillis();
        map.entrySet().removeIf(entry -> entry.getValue().isExpired(currentTime));
    }
}

// Thread-Pool-Based Cleanup Implementation
class ThreadPoolBasedCleanupMap<K, V> {
    private final Map<K, ExpiringEntry<V>> map;
    private final ScheduledExecutorService cleanupExecutor;
    private final long cleanupIntervalMillis;

    public ThreadPoolBasedCleanupMap(long cleanupIntervalMillis) {
        this.map = new ConcurrentHashMap<>();
        this.cleanupExecutor = Executors.newSingleThreadScheduledExecutor();
        this.cleanupIntervalMillis = cleanupIntervalMillis;
        startCleanupTask();
    }

    public void put(K key, V value, long ttlMillis) {
        long expirationTime = System.currentTimeMillis() + ttlMillis;
        map.put(key, new ExpiringEntry<>(value, expirationTime));
    }

    public V get(K key) {
        ExpiringEntry<V> entry = map.get(key);
        return (entry == null || entry.isExpired()) ? null : entry.value;
    }

    public boolean containsKey(K key) {
        ExpiringEntry<V> entry = map.get(key);
        return entry != null && !entry.isExpired();
    }

    public void remove(K key) {
        map.remove(key);
    }

    private void startCleanupTask() {
        cleanupExecutor.scheduleAtFixedRate(this::cleanupExpiredEntries, cleanupIntervalMillis, cleanupIntervalMillis, TimeUnit.MILLISECONDS);
    }

    private void cleanupExpiredEntries() {
        long currentTime = System.currentTimeMillis();
        map.entrySet().removeIf(entry -> entry.getValue().isExpired(currentTime));
    }

    public void shutdown() {
        cleanupExecutor.shutdown();
    }
}

// Example Usage
public class ExpiringMapExample {
    public static void main(String[] args) {
        System.out.println("=== Demand-Based Cleanup Map ===");
        DemandBasedCleanupMap<String, String> demandMap = new DemandBasedCleanupMap<>();
        demandMap.put("key1", "value1", 3000); // 3 seconds TTL
        demandMap.put("key2", "value2", 10000); // 10 seconds TTL

        try {
            Thread.sleep(4000); // Wait 4 seconds
            System.out.println("Key1: " + demandMap.get("key1")); // Should be null (expired)
            System.out.println("Key2: " + demandMap.get("key2")); // Should be "value2"

            Thread.sleep(7000); // Wait another 7 seconds
            System.out.println("Key2: " + demandMap.get("key2")); // Should be null (expired)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Thread-Pool-Based Cleanup Map ===");
        ThreadPoolBasedCleanupMap<String, String> threadPoolMap = new ThreadPoolBasedCleanupMap<>(5000); // Cleanup every 5 seconds
        threadPoolMap.put("key1", "value1", 3000); // 3 seconds TTL
        threadPoolMap.put("key2", "value2", 10000); // 10 seconds TTL

        try {
            Thread.sleep(4000); // Wait 4 seconds
            System.out.println("Key1: " + threadPoolMap.get("key1")); // Should be null (expired)
            System.out.println("Key2: " + threadPoolMap.get("key2")); // Should be "value2"

            Thread.sleep(7000); // Wait another 7 seconds
            System.out.println("Key2: " + threadPoolMap.get("key2")); // Should be null (expired)
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolMap.shutdown();
        }
    }
}
