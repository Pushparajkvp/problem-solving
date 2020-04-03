package dev.pushparaj.problems;

import java.util.*;

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