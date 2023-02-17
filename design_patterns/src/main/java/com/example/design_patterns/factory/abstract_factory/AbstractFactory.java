package com.example.design_patterns.factory.abstract_factory;

/**
 * 定义：抽象工厂模式提供一个接口，用户创建相关或依赖对象的家族，而不需要明确指定具体类
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 可以让抽象工厂具有默认的实现方法
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。
 * 另一个特点就是把一群相关产品集合起来
 *
 * @author ZhuSiDao
 * @date 2020/11/19
 */
public class AbstractFactory {
}

interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Veggies[] createVeggies();

    Cheese createCheese();

    Pepperoni createPepperoni();

    Clams createClams();
}

class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    public Dough createDough() {
        // 创建不通实现类
        return new Dough() {
        };
    }

    public Sauce createSauce() {
        return new Sauce() {
        };
    }

    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

    public Cheese createCheese() {
        return new Cheese() {
        };
    }

    public Pepperoni createPepperoni() {
        return new Pepperoni() {
        };
    }

    public Clams createClams() {
        return new Clams() {
        };
    }
}

/*
class NYPizzaStore implements PizzaStore{

}
*/

/**
 * 具体产品
 */
class CheesePizza extends Pizza {

    @Override
    void prepare() {

    }
}

/**
 * 具体产品
 */
class ClamPizza extends Pizza {

    @Override
    void prepare() {

    }
}

/**
 * 抽象产品
 */
abstract class Pizza {
    private String name;
    private Dough dough;
    private Sauce sauce;
    private Veggies[] veggies;
    private Cheese cheese;
    private Pepperoni pepperoni;
    private Clams clams;

    abstract void prepare();
}

interface Dough {
}

interface Sauce {
}

interface Veggies {
}

interface Cheese {
}

interface Pepperoni {
}

interface Clams {
}