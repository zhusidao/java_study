package com.example.data_structure_algorithm.leetcode;

import java.util.Stack;

/**
 * TODO
 *
 * @Author: sidao.zhu
 * @Date: 2021/12/13
 */
public class Practice10 {

    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*c"));
    }

    public static boolean isMatch(String s, String p) {
        Stack<Character> source = new Stack<>();
        Stack<Character> pattern = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            source.push(s.charAt(i));
        }
        for (int i = 0; i < p.length(); i++) {
            pattern.push(p.charAt(i));
        }
        char c1 = source.pop(), c2 = pattern.pop();
        if (pattern.isEmpty()) {
            if(!source.isEmpty()){
                return false;
            }
            return c1 == c2;
        }
        while (!pattern.isEmpty()) {
            if (c1 == c2 || c2 == '.') {
                c1 = source.pop();
                c2 = pattern.pop();
                continue;
            }

            if (c2 == '*') {
                c2 = pattern.pop();
                if (c2 != '.' && c2 != c1) {
                    c2 = pattern.pop();
                    continue;
                }
                while (!source.isEmpty() && ((c1 = source.pop()) == c2 || c2 == '.')) {
                }
                if (source.isEmpty()) {
                    if (pattern.isEmpty()) {
                        return true;
                    }
                    pattern.pop();
                }
                if (pattern.isEmpty()) {
                    return source.isEmpty();
                }
                c2 = pattern.pop();
            }
        }
        return source.isEmpty();
    }
}
