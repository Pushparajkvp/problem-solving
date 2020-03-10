package dev.pushparaj.searching;

import java.util.*;

public class BinarySearchTree {

    private static Node rootNode;
 
    public static int search(int[] arr, int value) {
        //Building the BST (This is not included in the complexity calculation)
        for(int it = 0; it < arr.length; it++)
            add(arr[it], it);
        int result = find(value);
        rootNode = null;
        return result;
    }

    private static int find(int data) {
        Node trav = rootNode;
        while(trav != null) {
            if(trav.data == data) return trav.index;
            else if(trav.data < data) trav = trav.right;
            else trav = trav.left;
        }
        return -1;
    }

    private static void add(int data, int index) {
        if(rootNode == null) {
            rootNode = new Node(data, index);
        } else {
            Node trav = rootNode;
            Node newNode = new Node(data, index);
            while(true) {
                if(trav.data > data){
                    if(trav.left == null) {
                        trav.left = newNode;
                        return;
                    }
                    trav = trav.left;
                }
                else {
                    if(trav.right == null) {
                        trav.right = newNode;
                        return;
                    }
                    trav = trav.right;
                }
            }
        }
    }

    private static class Node {
        public Node left, right;
        public int data, index;

        private Node() {}

        public Node(int data, int index) {
            this.left = this.right = null;
            this.data = data;
            this.index = index;
        }

        public Node(Node left,Node right, int data, int index) {
            this.left = left;
            this.right = right;
            this.data = data;
            this.index = index;
        }
    }
}