package com.example.jvm.book3_0.example.StringExample;

public class InternTest {
    public static void main(String[] args) {

        String str2 = new String("str")+new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2==str1);//#7
    }
}
