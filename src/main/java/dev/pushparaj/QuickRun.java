package dev.pushparaj;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.charset.*;
import java.lang.Math.*;

public class QuickRun {

    public static void run() {
        int[] arr = new int[]{10, 10, 3, 4, 10};

        int first=-1, second=-1, third=-1; 

        int average = 0;
        for(int i=0 ; i<arr.length; i++)
            average+=arr[i];
        average = average/arr.length;

        for(int i=0; i<arr.length; i++) {
            int diff = Math.abs(arr[i] - average);
            if(first == -1) {
                first = i;
            } else if(diff > Math.abs(arr[first] - average)) {
                third = second;
                second = first;
                first = i;
            } else if(second == -1) {
                second = i;
            } else if(diff > Math.abs(arr[second] - average)) {
                third = second;
                second = i;
            } else if(third == -1) {
                third = i;
            } else if(diff > Math.abs(arr[third] - average)){
                third = i;
            }
        }

        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(i != first && i != second && i != third) {
                if(arr[i] < min) min = arr[i];
                if(arr[i] > max) max = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(max - min);
    }   

    public static int amplitude(int[] arr) {
        int max=arr[0], min = arr[0];

        for(int it=0; it<arr.length; it++) {
            if(arr[it] > max)
                max = arr[it];
            if(arr[it] < min)
                min = arr[it];
        }

        return max - min;
    } 

}