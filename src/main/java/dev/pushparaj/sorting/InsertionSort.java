package dev.pushparaj.sorting;

import java.util.*;

/*
1. In Place
2. Stable
3. Best Case - O(n)
4. Average Case - O(1/4 * n^2)
5. Worst Case - O(1/2 * n^2)
6. Use for small or partially sorted arrays
*/
public class InsertionSort {

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}