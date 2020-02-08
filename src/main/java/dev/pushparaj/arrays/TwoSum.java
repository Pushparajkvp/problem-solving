package dev.pushparaj.arrays;

import java.util.HashMap;
/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(nums[i])){
                return new int[]{ map.get(nums[i]), i};
            }
            map.put(complement, i);
        }
        return new int[2];
    }
}
