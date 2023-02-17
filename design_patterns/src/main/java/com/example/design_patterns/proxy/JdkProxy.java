package com.example.design_patterns.proxy;


import java.lang.reflect.Proxy;

/**
 * JDK动态代理实现InvocationHandler接口
 */
public class JdkProxy {
    /**
     * 需要代理的目标对象
     */
    private Object target ;


    /**
     * 定义获取代理对象方法
     * @param targetObject
     * @return
     */
    private Object getJDKProxy(Object targetObject){
        //为目标对象target赋值
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("JDK动态代理，监听开始！");
                    Object result = method.invoke(target, args);
                    System.out.println("JDK动态代理，监听结束！");
                    return result;
                });
    }
    
    public static void main(String[] args) {
        // 实例化JDKProxy对象
        JdkProxy jdkProxy = new JdkProxy();
        // 获取代理对象
        Contact contact = (Contact) jdkProxy.getJDKProxy(new kobyStar());
        contact.call();
    }
    
}