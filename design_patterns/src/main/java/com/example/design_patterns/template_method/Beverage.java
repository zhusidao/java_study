package com.example.design_patterns.template_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 定义：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中，
 * 模版方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤
 *
 * 参考 java.util.Arrays.sort(Object[] objects)中的排序调用(Compare).compareTo()方法进行对象排序，就是一个模版方法模式
 * 由子类实现compareTo()的逻辑
 *
 * 策略模式：定义一个算法族，用组合的方式，让客户选择算法的实现--组合实现
 *
 * 模版方法模式：定一个算法大纲，而由子类定义其中某些步骤的内容--通常用继承去实现
 *
 *
 *
 * @author ZhuSiDao
 * @date 2020/11/24
 */
public abstract class Beverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class Tea extends Beverage {

    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding lemon");
    }
}

class Coffee extends Beverage {

    @Override
    void brew() {
        System.out.println("dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("adding sugar and milk");
    }
}


/* *****下面展示钩子的用法***** */

abstract class BeverageWithHook {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    boolean customerWantsCondiments() {
        return true;
    }
}

class CoffeeWithHook extends BeverageWithHook {

    @Override
    void brew() {
        System.out.println("dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("adding sugar and milk");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();
        return "y".equalsIgnoreCase(answer);
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }

    public static void main(String[] args) {
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        coffeeWithHook.prepareRecipe();
    }
}