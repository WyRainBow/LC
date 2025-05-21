package LRU.线程安全的LRU;

import java.util.*;

public class Main {
    static class SynchronizedLRUCache {
        private static class Node {
            int key, value;
            Node prev, next;

            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private final int capacity;
        private final Node dummy = new Node(0, 0); // 哨兵节点
        private final Map<Integer, Node> keyToNode = new HashMap<>();

        public SynchronizedLRUCache(int capacity) {
            this.capacity = capacity;
            dummy.prev = dummy;
            dummy.next = dummy;
        }

        public synchronized int get(int key) {
            Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        public synchronized void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            node = new Node(key, value);
            keyToNode.put(key, node);
            pushFront(node);
            if (keyToNode.size() > capacity) {
                Node backNode = dummy.prev;
                keyToNode.remove(backNode.key);
                remove(backNode);
            }
        }

        private void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }

        private void pushFront(Node x) {
            x.prev = dummy;
            x.next = dummy.next;
            x.prev.next = x;
            x.next.prev = x;
        }

        private Node getNode(int key) {
            if (!keyToNode.containsKey(key)) {
                return null;
            }
            Node node = keyToNode.get(key);
            remove(node);
            pushFront(node);
            return node;
        }
    }

    public static void main(String[] args) {
        SynchronizedLRUCache cache = new SynchronizedLRUCache(2);

        cache.put(1, 1); // 缓存是 {1=1}
        cache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3); // 淘汰 key=2
        System.out.println(cache.get(2)); // 返回 -1
        cache.put(4, 4); // 淘汰 key=1
        System.out.println(cache.get(1)); // 返回 -1
        System.out.println(cache.get(3)); // 返回 3
        System.out.println(cache.get(4)); // 返回 4
    }
}