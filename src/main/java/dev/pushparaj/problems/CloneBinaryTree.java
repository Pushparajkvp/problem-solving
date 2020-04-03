package dev.pushparaj.problems;

import java.util.*;

public class CloneBinaryTree {


    public static void clone(Node rootNode) {
        duplicateLeftChilds(rootNode);
        assignRandomPointers(rootNode);
        Node clonedListRoot = rootNode.left;
        seperateLists(rootNode);
        TreePrinter.printNode(rootNode);
        TreePrinter.printNode(clonedListRoot);
    }

    private static void duplicateLeftChilds(Node node) {
        if(node == null)
            return;
        Node newNode = new Node(node.data);
        newNode.left = node.left;
        node.left = newNode;
        duplicateLeftChilds(newNode.left);
        duplicateLeftChilds(node.right);
        if(node.right != null)
            newNode.right = node.right.left;
        else
            newNode. right = null;
    }
    private static void assignRandomPointers(Node node) {
        if(node == null)
            return;
        if(node.randomPointer != null) {
            node.left.randomPointer = node.randomPointer.left;
        }
        if(node.left != null)
            assignRandomPointers(node.left.left);
        assignRandomPointers(node.right);
    }
    private static void seperateLists(Node node) {
        if(node == null)
            return;
        if(node.left != null) {
            node.left = node.left.left;
        }
        seperateLists(node.left);
        seperateLists(node.right);
    }
}