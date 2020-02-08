package dev.pushparaj.arrays;

import java.util.*;
/*
*There are two sorted arrays nums1 and nums2 of size m and n respectively.
*Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*You may assume nums1 and nums2 cannot be both empty.
*/
public class MedianOfArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int smallerArraySize = nums1.length;
        int largerArraySize = nums2.length;

        if(largerArraySize < smallerArraySize) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tempSize = largerArraySize; largerArraySize = smallerArraySize; smallerArraySize = tempSize;
        }

        int left = 0, right = smallerArraySize, half = (largerArraySize + smallerArraySize + 1)/2;

        while(left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            if( i > left && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else if (i < right && nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else {
                int maxLeft = 0;
                if(i == 0) maxLeft = nums2[j - 1];
                else if(j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if((largerArraySize + smallerArraySize) % 2 == 1) return maxLeft;

                int minRight = 0;
                if(i == smallerArraySize) minRight = nums2[j];
                else if(j == largerArraySize) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}