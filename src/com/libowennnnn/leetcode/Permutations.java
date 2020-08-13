package com.libowennnnn.leetcode;
import java.util.*;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        for(int num: nums) cur.add(num);
        traceback(cur.size(), res, cur, 0);
        return res;
    }

    public void traceback(int n, List<List<Integer>> res, ArrayList<Integer> cur, int first){
        if(n == first) res.add(new ArrayList<Integer>(cur));
        for(int i = first; i < n; i++){
            Collections.swap(cur, first, i);
            traceback(n, res, cur, first + 1);
            Collections.swap(cur, first, i);
        }

    }
}