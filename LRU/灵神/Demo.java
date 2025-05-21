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

        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1、2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得 2 作废、缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得 1 作废、缓存是 {4=4、 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}