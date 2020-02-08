package dev.pushparaj.arrays;

import java.util.*;

/*
* Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
* n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
* Find two lines, which together with x-axis forms a container, such that the container contains the most water.
* Note: You may not slant the container and n is at least 2.
*/

public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = Integer.MIN_VALUE;
        while(left < right) {
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, min * (right - left));

            if(height[left] < height[right]) 
                left++;
            else 
                right--;
        }
        return maxArea;
    }
}