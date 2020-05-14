package com.arjun.algorithms.hashing;

/**
 * Created by arjuns on 1/5/17.
 */
public class HashTable<K, V> {

    private Object[] array;

    private int size = 20;

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(final Node<K, V> next) {
            this.next = next;
        }
    }


    public HashTable() {
        array = new Object[size];
    }

    public void insert(K key, V value) {
        checkKeyNull(key);

        int index = hash(key);
        if (array[index] == null) {
            array[index] = new Node(key, value);
        } else {
            Node<K, V> node = (Node<K, V>) array[index];
            Node<K, V> lastNode = null;
            while (node != null) {
                lastNode = node;
                node = node.getNext();
            }
            Node<K, V> newNode = new Node<>(key, value);
            lastNode.setNext(newNode);
        }
    }

    public V get(K key) {
        checkKeyNull(key);
        int index = hash(key);
        if (array[index] != null) {
            Node<K, V> node = (Node<K, V>) array[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.getNext();
            }

        }
        return null;
    }

    public V remove(K key) {
        checkKeyNull(key);
        int index = hash(key);
        if (array[index] != null) {
            Node<K, V> node = (Node<K, V>) array[index];
            Node<K, V> lastNode = null;
            while (node != null) {
                if (node.key.equals(key)) {
                    lastNode.setNext(node.getNext());
                    node.setNext(null);
                    return node.value;
                }
                lastNode = node;
                node = node.getNext();
            }
        }
        return null;
    }

    private int hash(final K key) {
        int i = key.hashCode();
        return Math.abs(i) % size;
    }

    private void checkKeyNull(final K key) {
        if (key == null) {
            throw new RuntimeException("key value is null");
        }
    }
}
