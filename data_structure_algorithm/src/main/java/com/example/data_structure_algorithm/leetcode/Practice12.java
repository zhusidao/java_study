package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/14
 */
public class Practice12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                num = num - 1000;
                roman.append("M");
            } else if (num >= 900) {
                num = num - 900;
                roman.append("CM");
            } else if (num >= 500) {
                num = num - 500;
                roman.append("D");
            } else if (num >= 400) {
                num = num - 400;
                roman.append("CD");
            } else if (num >= 100) {
                num = num - 100;
                roman.append("C");
            } else if (num >= 90) {
                num = num - 90;
                roman.append("XC");
            } else if (num >= 50) {
                num = num - 50;
                roman.append("L");
            } else if (num >= 40) {
                num = num - 40;
                roman.append("XL");
            } else if (num >= 10) {
                num = num - 10;
                roman.append("X");
            } else if (num >= 9) {
                num = num - 9;
                roman.append("IX");
            } else if (num >= 5) {
                num = num - 5;
                roman.append("V");
            } else if (num >= 4) {
                num = num - 4;
                roman.append("IV");
            } else if (num >= 1) {
                num = num - 1;
                roman.append("I");
            }
        }
        return roman.toString();
    }
}
