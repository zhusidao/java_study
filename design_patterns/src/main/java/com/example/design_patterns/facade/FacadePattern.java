package com.example.design_patterns.facade;


/**
 * 定义：外观模式提供一个统一的接口，用来访问子系统中的一群接口。外观模式定义了一个高层接口，让子系统更容易使用。
 *
 * 外观模式要求一个子系统的外部与其内部的通信通过一个统一的外观对象进行，外观类将客户端与子系统的内部复杂性分隔开，
 * 使得客户端只需要与外观对象打交道，而不需要与子系统内部的很多对象打交道。 外观模式的目的在于降低系统的复杂程度。
 *
 * service层就可以理解为外观模式
 *
 * 适用环境：
 * 为访问一系列复杂子系统提供简单的入口。
 * 客户端和子系统之间存在很大依赖。
 * 层次化结构中使用外观模式定义每一层的入口，层与层不直接产生联系，降低耦合度。
 *
 * @author ZhuSiDao
 * @date 2020/11/20
 */

public class FacadePattern {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.method();
    }
}

//外观角色
class Facade {
    private SubSystem01 obj1 = new SubSystem01();
    private SubSystem02 obj2 = new SubSystem02();
    private SubSystem03 obj3 = new SubSystem03();

    public void method() {
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }
}

//子系统角色
class SubSystem01 {
    public void method1() {
        System.out.println("子系统01的method1()被调用！");
    }
}

//子系统角色
class SubSystem02 {
    public void method2() {
        System.out.println("子系统02的method2()被调用！");
    }
}

//子系统角色
class SubSystem03 {
    public void method3() {
        System.out.println("子系统03的method3()被调用！");
    }
}