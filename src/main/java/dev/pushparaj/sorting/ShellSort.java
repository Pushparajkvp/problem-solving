package dev.pushparaj.sorting;

import java.util.*;

/*
1. In Place
2. Stable
3. Best Case - O(nlogn)
4. Average - O(nlogn)
5. Worst - O(n^2)
*/
public class ShellSort {

    public static void sort(int[] arr) {
        int gap = arr.length / 2;
        while(gap >= 1) {
            for(int i = gap; i < arr.length; i++) {
                for(int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j-=gap) {
                    swap(arr, j, j + gap);
                }
            }
            gap/=2;
        }
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}