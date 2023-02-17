package com.example.design_patterns.factory.factory_method;

/**
 * 和简单工厂差异
 * 简单工厂把全部的事情，在一个地方处理完了
 * 工厂方法却是创建一个框架，让子类决定要如何实现
 *
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 * 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 * @author ZhuSiDao
 * @date 2020/11/19
 */

/**
 * 抽象工厂
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

/**
 * 纽约工厂
 */
class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        if("type".equals("cheese")){
            return new NYStyleCheesePizza();
        }
        return null;
    }
}

/**
 * 芝加哥工厂
 */
class ChicagoPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        if("type".equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}

/**
 * 具体产品
 */
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY style Sauce and Cheese Pizza";
        dough = "This Crust Dough";
        sauce = "Marinara Sauce";
    }
}

/**
 * 具体产品
 */
class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza(){
        name = "Chicago style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
    }
}

/**
 * 抽象产品
 */
abstract class Pizza {
    String name;
    String dough;
    String sauce;

    void prepare() {
        System.out.println("prepare");
    }

    void bake() {
        System.out.println("bake");
    }

    void cut() {
        System.out.println("cut");
    }

    void box() {
        System.out.println("box");
    }
}

class MainTest{
    public static void main(String[] args) {

    }
}