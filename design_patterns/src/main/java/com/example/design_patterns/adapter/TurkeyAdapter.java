package com.example.design_patterns.adapter;

/**
 * 适配器模式将一个类的接口，转化成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间。
 *
 * @author ZhuSiDao
 * @date 2020/11/23
 */

/**
 * 适配器
 */
public class TurkeyAdapter implements Duck {
    /**
     * 组合了被适配者
     */
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

    public static void main(String[] args) {
        WildTurkey wildTurkey = new WildTurkey();
        Duck adapter = new TurkeyAdapter(wildTurkey);
        adapter.quack();
        adapter.fly();
    }
}

/**
 * 目标接口
 */
interface Duck {
    void quack();

    void fly();
}

class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}

/**
 * 被适配者
 */
interface Turkey {
    void gobble();

    void fly();
}

class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}