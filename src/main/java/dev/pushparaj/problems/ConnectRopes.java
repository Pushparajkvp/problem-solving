package dev.pushparaj.problems;

import java.util.*;

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