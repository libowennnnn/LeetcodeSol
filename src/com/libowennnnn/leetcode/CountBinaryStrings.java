package com.libowennnnn.leetcode;

//696
public class CountBinaryStrings {
    public int countBinSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(isReverse(s, i)) count++;
        }
        return count;
    }

    public boolean isReverse(String s, int idx){
        int start = idx + 1;
        int count = 1;
        while(start < s.length()){
            if(s.charAt(start) == s.charAt(idx)) {
                count++;
                start++;
            }
            else break;
        }
        while(start < s.length() && count > 0){
            if(s.charAt(start) != s.charAt(idx)) {
                count--;
                start++;
            }

            else break;
        }
        if (count == 0) return true;
        return false;
    }
}
    
