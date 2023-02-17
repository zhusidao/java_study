package com.example.data_structure_algorithm.jike.link.回文字;

import java.util.Scanner;

/**
 * 基于数组
 */
public class Owner {
    public static void main(String[] args) {
        //构造一个Scanner对象，其传入参数为
        System.out.println(ifHw());
    }

    public static boolean ifHw() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
