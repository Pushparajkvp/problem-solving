package dev.pushparaj.trees;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.utils.*;

public class TestCases extends BaseTest {
    @Test
    public void checkIfBstTests() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        assertTrue(CheckIfBST.check(root));
        root.left.left = new Node(10);
        assertFalse(CheckIfBST.check(root));
    }

    @Test
    public void checkBASTAdddGreaterNumbers(){
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        TreePrinter.printNode(root);
        BSTAddGreaterNumbers.addGreaterNumbers(root);
        TreePrinter.printNode(root);
    }

    
    @Test
    public void bottomViewTest() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        TreePrinter.printNode(root);
        BottomViewOfTree.print(root);
    }

    @Test
    public void cloneBinaryTreeTest() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.randomPointer = root.left;
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        root.right.left.randomPointer = root.right.right;
        root.randomPointer = root.right.right;
        TreePrinter.printNode(root);
        CloneBinaryTree.clone(root);
    }
}