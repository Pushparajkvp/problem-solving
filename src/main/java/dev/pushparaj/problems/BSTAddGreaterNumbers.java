package dev.pushparaj.problems;

import java.util.*;
import dev.pushparaj.utils.*;

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