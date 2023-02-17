package com.example.design_patterns.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


/**
 * Cglib动态代理，实现MethodInterceptor接口
 *
 */
public class CglibProxy {
    /**
     * 需要代理的目标对象
     */
    private Object target;

    /**
     * 定义获取代理对象方法
     */
    public Object getCglibProxy(Object objectTarget) {
        //为目标对象target赋值
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("Cglib动态代理，监听开始！");
            Object invoke = method.invoke(target, objects);//方法执行，参数：target 目标对象 arr参数数组
            System.out.println("Cglib动态代理，监听结束！");
            return invoke;
        });// 设置回调
        return enhancer.create();
    }

    public static void main(String[] args) {
        // 实例化CglibProxy对象
        CglibProxy cglib = new CglibProxy();
        Contact contact = (Contact) cglib.getCglibProxy(new kobyStar());
        contact.call();
    }

}
