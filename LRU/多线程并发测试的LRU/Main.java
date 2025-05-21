package LRU.多线程并发测试的LRU;

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

        public synchronized void printCacheState() {
            Node cur = dummy.next;
            System.out.print("Cache state (MRU -> LRU): ");
            while (cur != dummy) {
                System.out.print("[" + cur.key + "=" + cur.value + "] ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedLRUCache cache = new SynchronizedLRUCache(3);

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                cache.put(i, i * 100);
                System.out.println(Thread.currentThread().getName() + " put(" + i + "," + (i * 100) + ")");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {
                }
            }
        }, "Writer");

        Thread reader = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                int val = cache.get(i);
                System.out.println(Thread.currentThread().getName() + " get(" + i + ") = " + val);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ignored) {
                }
            }
        }, "Reader");

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println("\nFinal state:");
        cache.printCacheState();
    }

}