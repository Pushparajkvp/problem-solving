package dev.pushparaj.searching;

import java.util.*;

public class HashTableSeperateChaining {

    public static int search(int[] arr, int value) {
        HashMapImpl<Integer, Integer> map = new HashMapImpl<>();
        for(int it = 0; it < arr.length; it++){
            map.set(Integer.valueOf(arr[it]), Integer.valueOf(it));
        }
        Integer result = map.get(Integer.valueOf(value));
        return result == null ? -1 : result;
    }

    private static class HashMapImpl<K,V> {

        public static final int DEFAULT_CAPACITY = 7;
        public static final double DEFAULT_THRESHOLD = 0.75;
        
        private LinkedList<Entry<K,V>>[] table;
        
        private int capacity, size, maxSize;
        private double threshold;

        public HashMapImpl() {
            this.capacity = DEFAULT_CAPACITY;
            this.threshold = DEFAULT_THRESHOLD;
            this.size = 0;
            this.maxSize = (int) Math.floor(this.capacity * this.threshold);
            table = new LinkedList[this.capacity];
        }

        public V set(K key, V value) {
            int index = normaliseIndex(key.hashCode());
            LinkedList<Entry<K,V>> list = table[index];
            if(list == null){
                list = new LinkedList();
                table[index] = list;
            } else {
                for(Entry<K,V> entry : list) {
                    if(entry.key == key){
                        V valueToReturn = entry.value;
                        entry.value = value;
                        return valueToReturn;
                    }
                }
            }
            if(this.size > maxSize) {
                resizeTable();
            }
            list.add(new Entry<K,V>(key, value));
            this.size++;
            return null;
        }

        public V get(K key) {
            int index = normaliseIndex(key.hashCode());
            LinkedList<Entry<K,V>> list = table[index];
            if(list != null) {
                for(Entry<K,V> entry : list) {
                    if(entry.key == key){
                        return entry.value;
                    }
                }
            }
            return null;
        }

        private void resizeTable() {
            this.size = 0;
            this.capacity *= 2;
            this.maxSize = (int) Math.floor(this.capacity * this.threshold);

            LinkedList<Entry<K,V>>[] oldTable = table;
            table = new LinkedList[this.capacity];

            for(int it = 0; it < oldTable.length; it++) {
                LinkedList<Entry<K,V>> list = oldTable[it];
                if(list != null) {
                    for(Entry<K,V> entry : list) {
                        set(entry.key, entry.value);
                    }
                }
            }
        }

        private int normaliseIndex(int hash) {
            return (hash & 0x7FFFFFFF) % capacity;
        }

        private static class Entry<K,V> {
            
            public V value;
            public K key;
            public int hash;

            public Entry(K key, V value) {
                this.value = value;
                this.key = key;
                this.hash = key.hashCode();
            }

            @Override
            public String toString() {
                return key + " -> " + value;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int it = 0; it < table.length; it++) {
                LinkedList<Entry<K,V>> list = table[it];
                if(list != null) {
                    for(Entry<K,V> entry : list) {
                        sb.append(entry.toString() + "\n");
                    }
                }
            }
            return sb.toString();
        }
    }
    
}