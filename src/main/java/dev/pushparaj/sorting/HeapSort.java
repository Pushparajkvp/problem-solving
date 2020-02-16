package dev.pushparaj.sorting;

import java.util.*;

public class HeapSort {

    static int heapSize = 0;

    public static void sort(int[] arr) {
        heapSize = arr.length;
        
        //Heapify
        for(int i = Math.max(0, (arr.length /2) - 1); i >= 0; i--) {
            sink(arr, i);
        }
        for(int i = 0; i < arr.length; i++) poll(arr);
    }

    private static void sink(int[] arr, int index) {
        if(arr == null || arr.length == 0) return;

        while(true) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            int biggerValueIndex = left;

            if(right < heapSize && arr[right] > arr[biggerValueIndex]) biggerValueIndex = right;

            if(biggerValueIndex >= heapSize || arr[biggerValueIndex] < arr[index]) break;
            swap(arr, index, biggerValueIndex);
            index = biggerValueIndex;
        }
    }

    private static int poll(int[] arr) {
        if(arr == null || arr.length == 0) return -1;

        if(heapSize == 0) return -1;

        int returnData = arr[0];
        swap(arr, 0, heapSize - 1);
        heapSize--;
        sink(arr, 0);
        return returnData;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}