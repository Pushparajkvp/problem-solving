package dev.pushparaj.linked_list;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.utils.*;

public class TestCases extends BaseTest {
    @Test
    public void linkedListLoopRemovalTest() {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = head.next.next;
        LinkedListRemoveLoops.removeLoops(head);
    }
}