package dev.pushparaj.arrays;

/* 
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int it=1; it<nums.length; it++) {
            if(nums[it - 1] > 0) nums[it] += nums[it - 1];
            max = Math.max(nums[it], max);
        }
        return max;
    }
}