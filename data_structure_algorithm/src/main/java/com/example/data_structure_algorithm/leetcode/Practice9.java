package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/8
 */
public class Practice9 {

    public static void main(String[] args) {
        System.out.println(so(1534236469));
    }


    static int so(int x) {
        long reverse = 0;
        int per;
        while (x != 0) {
            per = x % 10;
            reverse = reverse * 10 + per;
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) reverse;
    }


}
