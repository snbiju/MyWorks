package com.app.test.practice.simple_cache;

public class SimpleCacheTest {

    public static void main(String[] args) throws InterruptedException {
        SimpleCacheTest simpleCache = new SimpleCacheTest();

        simpeCachePrint("\n\n==========Test1: crunchifyTestAddRemoveObjects ==========");
        simpleCache.simpleCahceTestAddRemoveObjects();

        simpeCachePrint("\n\n==========Test2: crunchifyTestExpiredCacheObjects ==========");
        simpleCache.simpleCacheTestExpiredCacheObjects();

        simpeCachePrint("\n\n==========Test3: crunchifyTestObjectsCleanupTime ==========");
        simpleCache.simpleCacheTestObjectsCleanupTime();
    }
    private void simpleCahceTestAddRemoveObjects() {
        // Test with crunchifyTimeToLive = 200 seconds
        // crunchifyTimerInterval = 500 seconds
        // maxItems = 6
        SimpleCache<String, String> cache = new SimpleCache<>(200, 500, 6);
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("Crunchify", "Crunchify");
        cache.put("Facebook", "Facebook");

        simpeCachePrint("6 Cache Object Added.. cache.size(): " + cache.size());
        cache.remove("IBM");
        simpeCachePrint("One object removed.. cache.size(): " + cache.size());
        cache.put("Twitter", "Twitter");
        cache.put("SAP", "SAP");
        simpeCachePrint("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
    }

    private static void simpeCachePrint(String s) {

        System.out.println(s);
    }

    private void simpleCacheTestExpiredCacheObjects() throws InterruptedException {
        // Test with crunchifyTimeToLive = 1 second
        // crunchifyTimerInterval = 1 second
        // maxItems = 10
        SimpleCache<String, String> cache = new SimpleCache<>(1, 1, 10);
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");

        // Adding 3 seconds sleep. Both above objects will be removed from
        // Cache because of timeToLiveInSeconds value
        Thread.sleep(3000);

        simpeCachePrint("Two objects are added but reached timeToLive. cache.size(): " + cache.size());
    }
    private void simpleCacheTestObjectsCleanupTime() throws InterruptedException {
        int size = 500000;
        // Test with timeToLiveInSeconds = 100 seconds
        // timerIntervalInSeconds = 100 seconds
        // maxItems = 500000
        SimpleCache<String, String> cache = new SimpleCache<>(100, 100, 500000);
        for (int i = 0; i < size; i++) {

            // toString(): Returns a String object representing the specified integer.
            // The argument is converted to signed decimal representation and returned as a string,
            // exactly as if the argument and radix 10 were given as arguments to the toString(int, int) method.
            String value = Integer.toString(i);
            cache.put(value, value);
        }
        Thread.sleep(200);
        long start = System.currentTimeMillis();
        cache.simpleCleanup();
        double finish = (double) (System.currentTimeMillis() - start) / 1000.0;

        simpeCachePrint("Cleanup times for " + size + " objects are " + finish + " s");
    }
}