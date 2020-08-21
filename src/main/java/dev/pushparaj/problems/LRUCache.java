package dev.pushparaj.problems;

import java.util.*;

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