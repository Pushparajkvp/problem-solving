package dev.pushparaj.sorting;

import java.util.*;

public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[low], left = low + 1, right = high;
        while(true) {
            while(arr[left++] < pivotValue) if(left == high) break;
            while(arr[right--] > pivotValue) if(right == low) break;
            if(left >= right) break;
            swap(arr, left, right);
        }
        swap(arr, low, right);
        return right;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        System.out.println("Before Partition -> " + Arrays.toString(Arrays.copyOfRange(arr, low , high + 1)));
        int partitionIndex = partition(arr, low, high);
        System.out.println("After Partition -> " + Arrays.toString(Arrays.copyOfRange(arr, low , high + 1)) + " Pivot Index -> " + (partitionIndex - low));
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        System.out.println("Swapping -> " + arr[firstIndex] + " and " + arr[secondIndex]);
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}