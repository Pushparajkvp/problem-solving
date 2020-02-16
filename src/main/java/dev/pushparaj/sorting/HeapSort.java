package dev.pushparaj.sorting;

import java.util.*;

public class HeapSort {

    static int[] tree; 
    static int heapSize = 0;

    public static void sort(int[] arr) {
        tree = arr.clone();
        heapSize = tree.length;
        
        //Heapify
        for(int i = Math.max(0, (arr.length /2) - 1); i >= 0; i--) {
            sink(tree, i);
        }
        for(int i = 0; i < arr.length; i++)
            arr[i] = poll();
    }

    private static void sink(int[] arr, int index) {
        if(tree == null || tree.length == 0) return;

        while(true) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            int smallestIndex = left;

            if(right < heapSize && arr[right] < arr[smallestIndex]) smallestIndex = right;

            if(smallestIndex >= heapSize || arr[smallestIndex] > arr[index]) break;
            swap(arr, index, smallestIndex);
            index = smallestIndex;
        }
    }

    private static int poll() {
        if(tree == null || tree.length == 0) return -1;

        if(heapSize == 0) return -1;

        int returnData = tree[0];
        swap(tree, 0, heapSize - 1);
        heapSize--;
        sink(tree, 0);
        return returnData;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}