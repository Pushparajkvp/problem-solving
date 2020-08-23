package dev.pushparaj.linked_list;

import java.util.*;
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /capacity/ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
class LRUCache {
    
    private class Node {
        int value, key;
        Node next, prev;
        
        public Node(int value, int key, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
            this.key = key;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Key:" + key + " value:" + value + "->");
            Node trav = next;
            while(trav != null)  {
                sb.append("Key:" + trav.key + " value:" + trav.value + "->");
                trav = trav.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }
    
    private void addFirst(Node node) {
        if(head == null) {
            head = node;
            tail = head;
            return;
        }
        
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    private void delete(Node node) {
        if(node == head) {
            head = head.next;
            if(head != null)
                head.prev = null;
        } else if(node == tail) {
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node = null;
    }
    
    private void moveToHead(Node node) {
        delete(node);
        addFirst(node);
    }
    
    
    HashMap<Integer,Node> map = null;
    int capacity = 0,size = 0;
    Node head = null, tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;
        moveToHead(node);
        return head.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        Node newNode = new Node(value, key, null, null);
        if(this.size < this.capacity) {
            addFirst(newNode);
            map.put(key, newNode);
            size++;
        } else {
            map.remove(tail.key);
            delete(tail);
            addFirst(newNode);
            map.put(key, newNode);
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */