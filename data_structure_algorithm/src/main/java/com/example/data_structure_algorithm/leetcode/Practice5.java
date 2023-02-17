package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/14
 */
public class Practice5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        int maxStart = 0, maxEnd = 0;
        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length - 1; index++) {
            int i = index, j = index;
            while ((i < chars.length - 1) && chars[j] == chars[i + 1]) {
                i++;
            }
            if ((i - j) > (maxEnd - maxStart)) {
                maxEnd = i;
                maxStart = j;
            }
            while (i < chars.length && j >= 0) {

                if (chars[i] != chars[j]) {
                    break;
                } else if ((i - j) > (maxEnd - maxStart)) {
                    maxEnd = i;
                    maxStart = j;
                }
                i++;
                j--;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
