package com.libowennnnn.leetcode;

//41
public class FirstMissionPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 1 || nums[i] > nums.length){
                nums[i] = nums.length + 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            int tmp = nums[i];
            if(tmp < 0) tmp = -tmp;
            if( tmp < nums.length + 1){
                nums[tmp - 1] = -nums[tmp - 1];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) return i+1;
        }
        return nums.length + 1;
    }
}

