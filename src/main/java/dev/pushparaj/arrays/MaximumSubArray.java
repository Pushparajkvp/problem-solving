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