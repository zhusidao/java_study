package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/9
 */
public class Practice11 {

    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (right > left) {
            int len = Math.min(height[left], height[right]);
            max = Math.max((right - left) * len, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
