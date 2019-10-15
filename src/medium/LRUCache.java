package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Problem 146: LRU Cache
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, CacheItem> cache;
    private Queue<Integer> order;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        order = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheItem item = cache.get(key);
        item.updateCount++;
        order.add(key);
        return item.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            CacheItem item  = cache.get(key);
            item.value = value;
            item.updateCount++;
        } else {
            cache.put(key, new CacheItem(value));
        }
        order.add(key);

        while (cache.size() > capacity) {
            int last = order.remove();
            CacheItem item = cache.get(last);
            if (item.updateCount <= 0) {
                cache.remove(last);
            } else {
                item.updateCount--;
            }
        }
    }

    private static class CacheItem {
        private int value;
        private int updateCount;

        public CacheItem(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        System.out.println(cache.cache);
    }
}
