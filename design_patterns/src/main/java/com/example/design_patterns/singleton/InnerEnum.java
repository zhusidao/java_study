package com.example.design_patterns.singleton;

/**
 * 内部枚举单例--懒加载
 * 利用枚举final static属性
 *
 * @author ZhuSiDao
 * @date 2020/11/18
 */
public class InnerEnum {

    private enum EnumClass {
        //
        TEST,
        SINGLETON;

        private InnerEnum innerEnum;

        EnumClass() {
            this.innerEnum = new InnerEnum();
        }

        private InnerEnum getInstance() {
            return innerEnum;
        }

        /**
         * 调用枚举方法所有的枚举实例都会调用构造方法
         */
        public static void method(){
            System.out.println(123);
        }
    }

    private static InnerEnum getInstance() {
        return EnumClass.SINGLETON.getInstance();
    }

    public static void main(String[] args) {
        EnumClass.method();
    }
}
