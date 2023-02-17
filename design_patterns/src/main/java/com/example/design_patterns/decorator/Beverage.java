package com.example.design_patterns.decorator;

/**
 * 装饰模式动态将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的代替方案
 * 参考mybatis二级缓存实现
 *
 * @author ZhuSiDao
 * @date 2020/11/20
 */

/**
 * 抽象饮料
 */
public abstract class Beverage {
    String description = "Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public static void main(String[] args) {
        HoneyDecorator honeyDecorator = new HoneyDecorator(new JellyDecorator(new HotBeverage()));
        System.out.println(honeyDecorator.getDescription());
        System.out.println(honeyDecorator.cost());
    }
}

/* 饮料类型*/

/**
 * 冷饮
 */
class ColdBeverage extends Beverage {

    @Override
    public double cost() {
        return 10;
    }
}

/**
 * 热饮
 */
class HotBeverage extends Beverage {

    @Override
    public double cost() {
        return 20;
    }
}


/* 对饮料进行调料 */

/**
 * 抽象装饰者
 * 调料
 */
abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    @Override
    public abstract String getDescription();
}

/**
 * 添加牛奶
 */
class MilkDecorator extends CondimentDecorator {

    public MilkDecorator(Beverage beverage) {
        super.beverage = beverage;
    }

    @Override
    public double cost() {
        return 5 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return "Milk" + beverage.getDescription();
    }
}

/**
 * 添加蜂蜜
 */
class HoneyDecorator extends CondimentDecorator {

    public HoneyDecorator(Beverage beverage) {
        super.beverage = beverage;
    }

    @Override
    public double cost() {
        return 7 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return "Honey " + beverage.getDescription();
    }
}

/**
 * 添加果冻
 */
class JellyDecorator extends CondimentDecorator {

    public JellyDecorator(Beverage beverage) {
        super.beverage = beverage;
    }

    @Override
    public double cost() {
        return 12 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return "jelly " + beverage.getDescription();
    }
}