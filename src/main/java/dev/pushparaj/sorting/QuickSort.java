package dev.pushparaj.sorting;

import java.util.*;

/*
1. In place
2. Not Stable
3. Best Case - O(nlogn)
4. Average Case - O(nlogn)
5. Worst Case - O(n^2)
6. Space Complexity - O(1)
*/
public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[high], left = low - 1, right = high;

        while(true) {
            while(++left <= high && arr[left] < pivotValue);
            while(--right >= low && arr[right] > pivotValue);

            if(left >= right) break;
            swap(arr, left, right);
        }
        swap(arr, high, left);

        return left;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}