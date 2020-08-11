package com.libowennnnn.leetcode;

public class binSubstring {
    public int countBinarySubstrings(String s) {
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

class TestbinSubstring{
    public static void main(String[] args){
        binSubstring t = new binSubstring();
        int result = t.countBinarySubstrings("00110011");
        System.out.println(result);
    }
    
}
