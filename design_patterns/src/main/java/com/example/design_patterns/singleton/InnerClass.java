package com.example.design_patterns.singleton;

/**
 * 静态内部类
 * 利用静态内类只有在使用的时候才会被加载
 *
 * @author ZhuSiDao
 * @date 2020/11/18
 */
public final class InnerClass {

    private InnerClass() {

    }

    private static class SingleClass {

        static {
            System.out.println(123);
        }

        private static final InnerClass InnerClass = new InnerClass();
    }

    public static InnerClass getInstance() {
        return SingleClass.InnerClass;
    }
}
