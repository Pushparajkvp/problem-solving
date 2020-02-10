package dev.pushparaj.sorting;

import java.util.*;

public class SelectionSort {

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            
            //Selected Index
            int minIndex = i; 

            //Finding minimum from rest of the array
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }

            //Swaping minimum with the selected index
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}