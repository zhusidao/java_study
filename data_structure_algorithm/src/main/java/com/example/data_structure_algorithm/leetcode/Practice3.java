package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/13
 */
public class Practice3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * a b c a b c
     * 0 1 2 3 4 5
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        int k = 0;
        int current = 1;
        for (int i = 1; i < chars.length; i++) {
            int j = i - 1;
            current++;
            for (; j >= k; j--) {
                if (chars[i] == chars[j]) {
                    current = i - j;
                    k = j + 1;
                    break;
                }
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
