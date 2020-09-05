package dev.pushparaj.linked_list;

/* 
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/

class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode iterator = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                iterator.next = l1;
                l1 = l1.next;
            } else {
                iterator.next = l2;
                l2 = l2.next;
            }
            iterator = iterator.next;
        }
        
        if(l1 != null) iterator.next = l1;
        if(l2 != null) iterator.next = l2;
        
        return dummy.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}