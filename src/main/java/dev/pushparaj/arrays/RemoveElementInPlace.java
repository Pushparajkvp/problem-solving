package dev.pushparaj.arrays;

import java.util.*;

/*
* Given an array nums and a value val, remove all instances of that value in-place and return the new length.
* Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
* The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class RemoveElementInPlace {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int newArrayPointer = nums[0] == val ? -1 : 0;
        for(int it = 1; it < nums.length; it++) {
            if(nums[it] != val) {
                nums[++newArrayPointer] = nums[it];
            }
        }
        return newArrayPointer + 1;
    }
}