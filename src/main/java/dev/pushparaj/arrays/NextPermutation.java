package dev.pushparaj.arrays;

import java.util.*;

/*
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
* If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
* The replacement must be in-place and use only constant extra memory.
* Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
*    1. Time Complexity - O(n)
*    2. Space Complexity - O(1)
*/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        for(int it = nums.length - 1; it > 0; it--) {
            if(nums[it - 1] < nums[it]) {
                int j = nums.length - 1;
                while(j > it - 1 && nums[j] <= nums[it - 1]) j--;
                swap(nums, it - 1, j);
                reverse(nums, it, nums.length - 1);
                return;
            }
        }

        reverse(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public void reverse(int[] nums, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}