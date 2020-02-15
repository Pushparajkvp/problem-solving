package dev.pushparaj.sorting;

import java.util.*;

public class MergeSort {

    private static void merge(int[] arr,int[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++)
            temp[i] = arr[i];
        for(int it = low, left = low, right = mid + 1; it <= high; it++) {
            if(left > mid) arr[it] = temp[right++];
            else if(right > high) arr[it] = temp[left++];
            else if(temp[left] > temp[right]) arr[it] = temp[right++];
            else arr[it] = temp[left++];
        }
    }
    
    private static void sort(int[] arr, int[] temp, int low, int high) {
        if(high <= low) return;
        int mid = low + ((high - low) / 2);
        sort(arr, temp, low, mid);
        sort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high);
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }
}