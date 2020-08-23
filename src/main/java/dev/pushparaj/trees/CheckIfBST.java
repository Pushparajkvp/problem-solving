package dev.pushparaj.trees;

import java.util.*;
import dev.pushparaj.utils.*;

/*
A binary search tree (BST) is a node based binary tree data structure which has the following properties.
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.

From the above properties it naturally follows that:
• Each node (item in the tree) has a distinct key.
*/
public class CheckIfBST {

    public static boolean check(Node root) {
        return recurse(root);
    }

    private static boolean recurse(Node node) {
        if(node == null)
            return true;

        if(node.left != null && node.left.data > node.data)
            return false;
        
        if(node.right != null && node.right.data < node.data)
            return false;
        
        return recurse(node.left) && recurse(node.right);
    }
}