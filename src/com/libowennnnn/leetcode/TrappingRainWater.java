package com.libowennnnn.leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int result = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        for (int i = 1; i < height.length - 1; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++){
            result = result + Math.min(left_max[i], right_max[i]) - height[i];
        }
        return result;
    }
}
