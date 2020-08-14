package com.libowennnnn.leetcode;

import java.util.HashMap;
import java.util.Stack;

//20
public class ValidParentheses {
    public boolean isValid(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek()!=map.get(c)) return false;
                stack.pop();
            }
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}
