package dev.pushparaj.arrays;

import java.util.*;

/*
* Given a sorted array and a target value, return the index if the target is found. 
* If not, return the index where it would be if it were inserted in order.
* You may assume no duplicates in the array.
*/

public class SearchInsertPosition {
    
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low < high) {
            int mid = low + ((high - low) / 2);

            if(nums[mid] == target) return mid;

            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return target > nums[low] ? low + 1 : low; 
    }
}