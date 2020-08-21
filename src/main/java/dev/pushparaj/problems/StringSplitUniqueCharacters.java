package dev.pushparaj;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.charset.*;
import java.lang.Math.*;

public class StringSplitUniqueCharacters {

    public static void run() {
        int[] left = new int[26];
        int[] right = new int[26];

        String word = "ababa";
        for(int i=0; i<word.length(); i++) {
            right[word.charAt(i) - 'a']++;
        }

        int ans = 0;
        for(int i=0; i<word.length(); i++) {
            left[word.charAt(i) - 'a']++;
            right[word.charAt(i) - 'a']--;
            int leftCount = numberOfUniqueChar(left);
            int rightCount = numberOfUniqueChar(right);
            if(leftCount == rightCount && leftCount !=0 && rightCount != 0) ans++;
        }

        System.out.println(ans);
    }

    private static int numberOfUniqueChar(int[] dic) {
        int count = 0;
        for(int i=0; i<dic.length; i++)
            if(dic[i] != 0) count++;
        return count; 
    }

}