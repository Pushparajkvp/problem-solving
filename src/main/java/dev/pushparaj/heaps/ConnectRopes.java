package dev.pushparaj.heaps;

import java.util.*;

/*
Connect n ropes with minimum cost
Last Updated: 17-07-2020
There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to the sum of their lengths. We need to connect the ropes with minimum cost.

For example, if we are given 4 ropes of lengths 4, 3, 2, and 6. We can connect the ropes in the following ways.
1) First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all ropes have connected.

Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
*/
public class ConnectRopes {
    
    public static int[] heap = null;
    public static int heapSize = 0;

    public static void connect(int[] ropes) {
        heap = ropes.clone();

        heapSize = heap.length;
        //heapify
        for(int it = Math.max(0, (heapSize / 2) - 1); it >= 0; it--)
            sink(it);
        while(heapSize >= 2) {
            int smallestRope = poll();
            int secondSmallestRope = poll();
            add(smallestRope + secondSmallestRope);
        }
        System.out.println("Most optimized cost : " + poll());
    }
    private static void add(int value) {
        heap[heapSize] = value;
        heapSize++;
        sink(heapSize - 1);
    }

    private static int poll() {
        swap(0, heapSize - 1);
        heapSize--;
        sink(0);
        return heap[heapSize];
    }

    private static void sink(int index) {
        int leftChild =  (2 * index) + 1;
        int rightChild = (2 * index) + 2;

        if(leftChild >= heapSize)
            return;
        
        int smallest = leftChild;

        if(rightChild < heapSize && heap[rightChild] < heap[smallest]) smallest = rightChild;

        if(heap[smallest] < heap[index]) {
            swap(smallest, index);
            sink(smallest);
        }
    }

    private static void swim(int index) {
        int parent = (index / 2) - 1;
        
        if(parent >= 0) {
            if(heap[parent] > heap[index]) {
                swap(parent, index);
                swim(parent);
            }
        }
    }

    private static void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }
}