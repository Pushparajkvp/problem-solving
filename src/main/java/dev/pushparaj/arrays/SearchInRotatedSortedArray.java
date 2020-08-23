package dev.pushparaj.arrays;

import java.util.*;

/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
* (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
* You are given a target value to search. If found in the array return its index, otherwise return -1.
* You may assume no duplicate exists in the array.
* Your algorithm's runtime complexity must be in the order of O(log n).
*    1. Time Complexity - O(logn)
*    2. Space Complexity - O(1)
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1; 

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if(nums[high] >= target && target > nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}