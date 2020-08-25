import java.util.*;
/* 
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

*/
class TrappedRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int answer = 0;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        while(left<right) {
            if(height[left] < height[right]) {
                if(leftMax < height[left]) 
                    leftMax = height[left];
                else {
                    answer += leftMax - height[left];
                }
                left++;
            } else {
                if(rightMax < height[right])
                    rightMax = height[right];
                else{
                    answer += rightMax - height[right];
                }
                right--;
            }
        }
        return answer;
    }
}