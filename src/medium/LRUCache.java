package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 146: LRU Cache
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        first = new Node();
        last = new Node();

        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        updateCache(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateCache(node);
        } else {
            if (map.size() >= capacity) {
                Node node = last.prev;
                removeNode(node);
                map.remove(node.key);
            }

            Node node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addToFront(node);
        }
    }

    private void updateCache(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToFront(Node node) {
        Node temp = first.next;
        first.next = node;
        node.prev = first;
        node.next = temp;
        temp.prev = node;
    }

    private static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
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

        System.out.println(cache.map);
    }
}
