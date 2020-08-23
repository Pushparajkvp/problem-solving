package dev.pushparaj.linked_list;

import java.util.*;
import dev.pushparaj.utils.*;

/* 
Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and if loop is present then removes the loop and returns true. If the list doesn’t contain loop then it returns false. Below diagram shows a linked list with a loop. detectAndRemoveLoop() must change the below list to 1->2->3->4->5->NULL.
*/
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