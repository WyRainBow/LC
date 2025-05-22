package LRU.灵神;


import java.util.*;

public class Demo {
    static class LRUCache {
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

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy.prev = dummy;
            dummy.next = dummy;
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

        public int get(int key) {
            Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        public void put(int key, int value) {
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
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        System.out.println("put(1, 1)");
        lRUCache.put(1, 1); // 缓存是 {1=1}

        System.out.println("put(2, 2)");
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}

        System.out.println("get(1) => " + lRUCache.get(1)); // 返回 1，缓存更新为 {2=2, 1=1}

        System.out.println("put(3, 3) // 缓存容量已满，淘汰最近最少使用的 key=2");
        lRUCache.put(3, 3); // 淘汰 key=2，缓存为 {1=1, 3=3}

        System.out.println("get(2) => " + lRUCache.get(2)); // 返回 -1，2 被淘汰

        System.out.println("put(4, 4) // 淘汰最近最少使用的 key=1");
        lRUCache.put(4, 4); // 淘汰 key=1，缓存为 {3=3, 4=4}

        System.out.println("get(1) => " + lRUCache.get(1)); // 返回 -1，1 被淘汰
        System.out.println("get(3) => " + lRUCache.get(3)); // 返回 3
        System.out.println("get(4) => " + lRUCache.get(4)); // 返回 4
    }



}