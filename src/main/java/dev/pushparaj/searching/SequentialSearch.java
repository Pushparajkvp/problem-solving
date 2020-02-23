package dev.pushparaj.searching;

import java.util.*;

public class SequentialSearch {

    public static int search(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == value) return i;
        return -1;
    }
}