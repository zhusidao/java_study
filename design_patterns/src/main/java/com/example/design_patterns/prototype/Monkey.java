package com.example.design_patterns.prototype;

/**
 * 原型模式的优点：
 * Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 * 可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 *
 * 原型模式的缺点：
 * 需要为每一个类都配置一个 clone 方法
 * clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
 * 当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。
 *
 * @author ZhuSiDao
 * @date 2020/11/19
 */
public class Monkey implements Cloneable {

    private ChildMonkey childMonkey = new ChildMonkey();

    private class ChildMonkey {

    }

    public Monkey() {
        System.out.println("construct");
    }

    /**
     * 引用类型不会直接创建新对象
     * @return
     */
    @Override
    protected Monkey clone() {
        Monkey monkey = null;
        try {
            monkey = (Monkey) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return monkey;
    }

    @Override
    public String toString() {
        return "Monkey:" + super.toString() + "{" +
                "childMonkey=" + childMonkey +
                '}';
    }

    public static void main(String[] args) {
        Monkey monkeyA = new Monkey();
        Monkey monkeyB = monkeyA.clone();
        System.out.println(monkeyA);
        System.out.println(monkeyB);
    }
}
