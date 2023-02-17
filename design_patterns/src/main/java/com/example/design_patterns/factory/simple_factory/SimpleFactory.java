package com.example.design_patterns.factory.simple_factory;

/**
 * 优点：
 * 1.工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例。客户端可以免除直接创建产品对象的职责，很方便的创建出相应的产品。工厂和产品的职责区分明确。
 * 2.客户端无需知道所创建具体产品的类名，只需知道参数即可。
 * 3.也可以引入配置文件，在不修改客户端代码的情况下更换和添加新的具体产品类。
 * 缺点：
 * 4.简单工厂模式的工厂类单一，负责所有产品的创建，职责过重，一旦异常，整个系统将受影响。且工厂类代码会非常臃肿，违背高聚合原则。
 * 5.使用简单工厂模式会增加系统中类的个数（引入新的工厂类），增加系统的复杂度和理解难度
 * 6.系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂
 * 7.简单工厂模式使用了 static 工厂方法，造成工厂角色无法形成基于继承的等级结构。
 * @author ZhuSiDao
 * @date 2020/11/19
 */
public class SimpleFactory {

    interface Product {
        void show();
    }


    static class ConcreteProductA implements Product {

        public void show() {
            System.out.println("productA");
        }
    }

    static class ConcreteProductB implements Product {

        public void show() {
            System.out.println("productB");
        }
    }

    public static Product concreteProduct(Class<?> clazz) {
        Product product = null;
        if (clazz.isAssignableFrom(ConcreteProductA.class)) {
            product = new ConcreteProductA();
        } else if (clazz.isAssignableFrom(ConcreteProductB.class)) {
            product = new ConcreteProductB();
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(concreteProduct(ConcreteProductB.class));
    }
}
