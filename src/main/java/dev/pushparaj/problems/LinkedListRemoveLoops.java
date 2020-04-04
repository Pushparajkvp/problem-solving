package dev.pushparaj.problems;

import java.util.*;

public class LinkedListRemoveLoops {
    
    public static void removeLoops(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while(slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next != null ? fastPointer.next.next : null;
            if(slowPointer == fastPointer) {
                slowPointer = head;
                while(slowPointer != fastPointer) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                while(fastPointer.next != slowPointer)
                    fastPointer = fastPointer.next;
                fastPointer.next = null;
            }
        }
        
        Node trav = head;
        while(trav != null) {
            System.out.print(trav.data + " ");
            trav = trav.next;
        }
    }
}