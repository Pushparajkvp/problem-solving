package dev.pushparaj.problems;

import java.util.*;

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