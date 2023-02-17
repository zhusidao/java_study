package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/17
 */
public class Practice16 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int min = (nums[0] + nums[1] + nums[2]);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < Math.abs(target - min)) {
                        min = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return min;
    }
}
