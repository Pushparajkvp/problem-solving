package dev.pushparaj.problems;

import java.util.*;

public class Node {
    
    public int data;
    public Node left = null, right = null, randomPointer = null;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}