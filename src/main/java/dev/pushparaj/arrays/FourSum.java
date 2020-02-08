package dev.pushparaj.arrays;

import java.util.*;

/* 
* Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
* Find all unique quadruplets in the array which gives the sum of target.
* Note:The solution set must not contain duplicate quadruplets.
*/

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        for(int firstSelectionIt = 0; firstSelectionIt < nums.length - 3; firstSelectionIt++) {
            if(firstSelectionIt != 0 && nums[firstSelectionIt] == nums[firstSelectionIt - 1])
                continue;
            for(int secondSelectionIt = firstSelectionIt + 1; secondSelectionIt < nums.length - 2; secondSelectionIt++) {
                if(secondSelectionIt != firstSelectionIt + 1 && nums[secondSelectionIt] == nums[secondSelectionIt - 1])
                    continue;
                
                int low = secondSelectionIt + 1;
                int high = nums.length - 1;
                int twoSum = nums[firstSelectionIt] + nums[secondSelectionIt];

                while(low < high) {
                    int sum = twoSum + nums[low] + nums[high];
                    if(sum == target) {
                        output.add(Arrays.asList(nums[firstSelectionIt], nums[secondSelectionIt], nums[low], nums[high]));
                        while(low < high && nums[low + 1] == nums[low]) low++;
                        while(low < high && nums[high - 1] == nums[high]) high--;
                        low++;
                        high--;
                    } else if (sum < target) {
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