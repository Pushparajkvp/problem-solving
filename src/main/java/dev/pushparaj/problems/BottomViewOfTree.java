package dev.pushparaj.problems;

import java.util.*;
import dev.pushparaj.utils.*;

public class BottomViewOfTree {

    private static SortedMap<Integer,Node> hdMap = new TreeMap<>();

    public static void print(Node rootNode) {
        find(rootNode, 0);
        for(Map.Entry<Integer,Node> entry : hdMap.entrySet()) {
            System.out.print(((Node)entry.getValue()).data + " ");
        }
    }

    private static void find(Node node, int hd) {
        if(node == null)
            return;

        find(node.left, hd - 1);
        hdMap.put(hd, node);
        find(node.right, hd + 1);
    }
}