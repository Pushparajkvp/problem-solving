import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        int len1 = Integer.MIN_VALUE, len2 = Integer.MIN_VALUE;
        for(int it=0; it<s.length(); it++) {
            len1 = expandAroundCenter(s, it, it);
            len2 = expandAroundCenter(s, it, it+1);
            
            len1 = Math.max(len1, len2);
            
            if(len1>max) {
                max = len1;
                start = it - (len1-1)/2;
                end = it + len1/2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s,int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}