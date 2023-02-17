package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/20
 */
public class Practice33 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
