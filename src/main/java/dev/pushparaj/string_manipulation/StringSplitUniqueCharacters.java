package dev.pushparaj.string_manipulation;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.charset.*;
import java.lang.Math.*;

/*
Given a string S, we can split S into 2 strings: S1 and S2. Return the number of ways S can be split such that the number of unique characters between S1 and S2 are the same.

Example 1:

Input: "aaaa"
Output: 3
Explanation: we can get a - aaa, aa - aa, aaa- a
Example 2:

Input: "bac"
Output: 0
Example 3:

Input: "ababa"
Output: 2
Explanation: ab - aba, aba - ba
*/
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