package dev.pushparaj.arrays;

import java.util.*;

/*
* Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
* Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
*    1. Time Complexity - O(n)
*    2. Space Complexity - O(1)
*/

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int counter = 1, replaceIterator = 0;
        for(int it = 1; it < nums.length; it++) {
            if(nums[replaceIterator] != nums[it]) {
                replaceIterator++;
                nums[replaceIterator] = nums[it];
            }
        }
        return replaceIterator + 1;
    }
}