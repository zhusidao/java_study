package com.example.design_patterns.proxy;

/**
 * 代理模式为另一个对象提供一个替身占位符以控制对这个对象的访问
 *
 * @author ZhuSiDao
 * @date 2020/11/25
 */

/**
 * 静态代理
 */
public class kobyStar implements Contact {

    @Override
    public void call() {
        System.out.println("hello i'm koby");
    }

    public static void main(String[] args) {
        Contact contact = new KobyAgent(new kobyStar());
        contact.call();
    }
}

interface Contact {
    void call();
}

class KobyAgent implements Contact {

    Contact contact;

    public KobyAgent(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void call() {
        System.out.println("I'm koby's agent, I will talk to her");
        contact.call();
        System.out.println("I'm koby's agent, I will talk to her");
    }
}


