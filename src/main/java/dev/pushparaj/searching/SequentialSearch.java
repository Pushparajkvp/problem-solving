package dev.pushparaj.searching;

import java.util.*;
/*
1. Worst Case
        1. Search - O(n)
        2. Insert - O(n)
        3. Delete - O(n)
2. Average Case
    1. Search - O(n)
    2. Insert - O(n)
    3. Delete - O(n)
*/
public class SequentialSearch {

    public static int search(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == value) return i;
        return -1;
    }
}