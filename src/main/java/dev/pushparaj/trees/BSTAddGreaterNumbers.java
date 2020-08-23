package dev.pushparaj.trees;

import java.util.*;
import dev.pushparaj.utils.*;

/*
Given a Binary Search Tree (BST), modify it so that all greater values in the given BST are added to every node. For example, consider the following BST.
              50
           /      \
         30        70
        /   \      /  \
      20    40    60   80 

The above tree should be modified to following 

              260
           /      \
         330        150
        /   \       /  \
      350   300    210   80
*/
public class BSTAddGreaterNumbers {

    private static int sum = 0;

    public static void addGreaterNumbers(Node root) {
        add(root);
    }

    private static void add(Node node) {
        if(node == null)
            return;
        add(node.right);
        int data = node.data;
        node.data += sum;
        sum += data;
        add(node.left);
    }
}