package com.example.data_structure_algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sidao.zhu
 * @Date: 2022/6/6
 */
public class Practice17 {

    static Character[][] dig = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        List<Character[]> list = new ArrayList<>();
        for (byte aByte : digits.getBytes()) {
            list.add(dig[aByte - '2']);
        }
        List<String> result = new ArrayList<>();
        digui(list, "", 0, result);
        return result;
    }

    static void digui(List<Character[]> list, String a, int deep, List<String> result) {
        if (deep == list.size()) {
            result.add(a);
        } else {
            Character[] characters = list.get(deep);
            for (Character aChar : characters) {
                digui(list, a + aChar, deep + 1, result);
            }
        }
    }


    public static void main(String[] args) {
        letterCombinations("24");
    }
}
