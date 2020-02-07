package dev.pushparaj;

import java.util.*;

/* 
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
* Find all unique triplets in the array which gives the sum of zero.
* Note: The solution set must not contain duplicate triplets.
*/

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        for(int it = 0; it < nums.length - 2; it++) {
            if(it == 0 || (it > 0 && nums[it] != nums[it - 1])){
                int complement = 0 - nums[it];
                
                //2 sum implementation
                int low = it + 1;
                int high = nums.length - 1;
                while(low < high) {
                    int sum = nums[low] + nums[high];
                    if(sum == complement) {
                        output.add(Arrays.asList(nums[it], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if(sum < complement) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            
        }
        return output;
    }
}