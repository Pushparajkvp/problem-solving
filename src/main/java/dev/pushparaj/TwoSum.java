package dev.pushparaj;

import java.util.HashMap;

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
