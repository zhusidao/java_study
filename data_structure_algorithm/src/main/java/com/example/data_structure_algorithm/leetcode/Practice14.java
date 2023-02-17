package com.example.data_structure_algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/9
 */
public class Practice14 {

    public static void main(String[] args) {
        String[] strs = {"a"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        String s = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get();
        int j;
        for (j = 0; j < s.length(); ) {
            if (eq(strs, s.charAt(j), j)) {
                j++;
            } else {
                return s.substring(0, j);
            }
        }
        return s.substring(0, j);
    }

    public static boolean eq(String[] strs, char s, int pos) {
        for (String str : strs) {
            if (s != str.charAt(pos)) {
                return false;
            }
        }
        return true;
    }
}
