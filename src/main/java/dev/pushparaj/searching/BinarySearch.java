package dev.pushparaj.searching;

import java.util.*;
import dev.pushparaj.sorting.*;

public class BinarySearch {

    public static int search(int[] arr, int value) {
        QuickSort.sort(arr);
        System.out.println("Sorted Array ->  " + Arrays.toString(arr));
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(arr[mid] == value)
                return mid;
            else if(arr[mid] > value)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}