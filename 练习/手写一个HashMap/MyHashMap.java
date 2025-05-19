package 练习.手写一个HashMap;

public class MyHashMap<K, V> {
    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V>[] table;
    private int size;
    private int capacity;
    private final float loadFactor;

    public MyHashMap() {
        this.capacity = 16;
        this.loadFactor = 0.75f;
        this.table = new Node[capacity];
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);
        Node<K, V> head = table[index];

        for (Node<K, V> node = head; node != null; node = node.next) {
            if (node.hash == hash && (key == node.key || (key != null && key.equals(node.key)))) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        table[index] = new Node<>(hash, key, value, head);
        size++;

        if (size > capacity * loadFactor) {
            resize();
        }

        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);

        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (node.hash == hash && (key == node.key || (key != null && key.equals(node.key)))) {
                return node.value;
            }
        }

        return null;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> node : table) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = indexFor(node.hash, newCapacity);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();

        map.put("name", "Alice");
        map.put("age", "25");
        map.put("language", "Java");



        System.out.println("name: " + map.get("name"));         // Alice
        System.out.println("age: " + map.get("age"));           // 25
        System.out.println("language: " + map.get("language")); // Java

        map.put("name", "Bob");
        System.out.println("updated name: " + map.get("name")); // Bob
    }
}