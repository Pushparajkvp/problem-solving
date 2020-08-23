package dev.pushparaj.arrays;

import java.util.*;
/* 
Given an array of positive integers arr[] and a sum x, find all unique combinations in arr[] where the sum is equal to x. The same repeated number may be chosen from arr[] unlimited number of times. Elements in a combination (a1, a2, …, ak) must be printed in non-descending order. (ie, a1 <= a2 <= … <= ak).
The combinations themselves must be sorted in ascending order, i.e., the combination with smallest first element should be printed first. If there is no combination possible the print "Empty" (without quotes).

Examples:

Input : arr[] = 2, 4, 6, 8 
            x = 8
Output : [2, 2, 2, 2]
         [2, 2, 4]
         [2, 6]
         [4, 4]
         [8]

    1. Time Complexity - O(n^(n/2))
*/
public class CombinationSum {
    

    public static void find(int[] arr, int sum) {
        Arrays.sort(arr);
        int newSize = removeDuplicates(arr);
        findComb(arr,new ArrayList<Integer>(), 0, newSize - 1, sum);
    }

    private static void findComb(int[] arr, List combo, int startIndex, int endIndex, int currSum) {
        if(currSum == 0) {
            System.out.println(combo.toString());
            return;
        }
        if(currSum < 0)
            return;
        
        for(int it = startIndex; it <= endIndex && arr[it] <= currSum; it++) {
            combo.add(arr[it]);
            findComb(arr, combo, it, endIndex, currSum - arr[it]);
            combo.remove(combo.size() - 1);
        }
    }

    private static int removeDuplicates(int[] arr) {
        int replaceIt = 0;
        for(int it = 1; it < arr.length; it++) {
            if(arr[replaceIt] != arr[it]) {
                replaceIt++;
                arr[replaceIt] = arr[it];
            }
        }
        return replaceIt + 1;
    }
}