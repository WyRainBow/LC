package LRU.有过期时间的LRU;

import java.util.*;

public class Main {
    static class LRUCache {
        private static class Node {
            int key, value;
            long expireTime;
            Node prev, next;

            Node(int k, int v, long expire) {
                key = k;
                value = v;
                expireTime = expire; //过期时间
            }
        }

        private final int capacity;
        private final Node dummy = new Node(0, 0, 0);
        private final Map<Integer, Node> keyToNode = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy.prev = dummy;
            dummy.next = dummy;
        }

        private Node getNode(int key) {
            if (!keyToNode.containsKey(key)) return null;
            Node node = keyToNode.get(key);
            if (System.currentTimeMillis() > node.expireTime) {
                keyToNode.remove(key);
                remove(node);
                return null;
            }
            remove(node);
            pushFront(node);
            return node;
        }

        public int get(int key) {
            Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        public void put(int key, int value, long ttlMillis) {
            Node node = getNode(key);
            long expireTime = System.currentTimeMillis() + ttlMillis;
            if (node != null) {
                node.value = value;
                node.expireTime = expireTime;
                return;
            }
            node = new Node(key, value, expireTime);
            keyToNode.put(key, node);
            pushFront(node);
            while (keyToNode.size() > capacity) {
                Node backNode = dummy.prev;
                if (System.currentTimeMillis() > backNode.expireTime) {
                    keyToNode.remove(backNode.key);
                    remove(backNode);
                } else {
                    keyToNode.remove(backNode.key);
                    remove(backNode);
                }
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
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCache cache = new LRUCache(2);

        // 放入两个值，TTL 为 1 秒
        cache.put(1, 100, 1000);
        cache.put(2, 200, 1000);
        System.out.println("get(1): " + cache.get(1)); // 应该输出 100

        // 等待 1.2 秒，key=1 和 key=2 都过期
        Thread.sleep(1200);
        System.out.println("get(1) after TTL: " + cache.get(1)); // 应该输出 -1
        System.out.println("get(2) after TTL: " + cache.get(2)); // 应该输出 -1

        // 插入一个新值
        cache.put(3, 300, 1000);
        System.out.println("get(3): " + cache.get(3)); // 应该输出 300

        Thread.sleep(1100);
        System.out.println("get(3) after TTL: " + cache.get(3)); // 应该输出 -1
    }
}