package com.veereshhonnala.datastructures;

import java.util.ArrayList;
import java.util.List;

//TODO: implement HashTable ds
public class HashTable<K, V> {
    private int DEFAULT_SIZE = 10;
    private int size;
    private List<Entry> objects;

    public HashTable() {
        size = 10;
        objects = new ArrayList<>(DEFAULT_SIZE);
    }

    public HashTable(int size) {
        if (size < 0) throw new IllegalArgumentException("size >0");
        this.size = size;
        objects = new ArrayList<>(size);
    }


    public V put(K key, V value) {
        int index = hashCode(key);
        return value;
    }

    public boolean keyContains(K key, int index) {
//        objects[index];
        return false;
    }

    datastructures.HashTable.Entry<K, V> createNewEntry(K key, V value) {
        return new Entry<K, V>(key, value);
    }

    static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void key(final K key) {
            this.key = key;
        }

        public K key() {
            return key;
        }

        public void value(V value) {
            this.value = value;
        }

        public V value() {
            return value;
        }

        public void next(Entry<K, V> entry) {
            this.next = entry;
        }

        public Entry<K, V> next() {
            return next;
        }
    }

    private int hashCode(K key) {
        return key.hashCode() % size;
    }

}
