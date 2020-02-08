package dev.pushparaj.arrays;

import java.util.*;

/*
* Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
* Return the sum of the three integers. You may assume that each input would have exactly one solution.
*/

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums); //O(nlogn) quick sort
        int sum = nums[0] + nums[1] + nums[2];
        int absDiff = Integer.MAX_VALUE;
        
        for(int it = 0; it < nums.length - 2; it++) {
            int low = it + 1;
            int high = nums.length - 1;

            while(low < high) {
                int currentSum = nums[it] + nums[low] + nums[high];
                int currentDiff = Math.abs(target - currentSum);

                if(currentDiff == 0 ) return currentSum;
                else if (currentDiff < absDiff) {
                    absDiff = currentDiff;
                    sum = currentSum;
                }

                if(currentSum <= target)
                    low++;
                else
                    high--;
            }

        }
        return sum;
    }
}