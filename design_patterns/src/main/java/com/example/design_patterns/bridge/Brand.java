package com.example.design_patterns.bridge;

/**
 * 装饰模式都有一个共同接口，装饰者模式中的行为具有可叠加性，其表现出来的结果是一个整体，一个各个行为组合后的一个结果
 * 桥接模式，桥接中的行为是横向的行为，行为彼此之间无关联
 */
//定义接口
public interface Brand {
    public void call();
}

//Vivo实现
class Vivo implements Brand {
    @Override
    public void call() {
        System.out.println("Vivo 开机");
    }

}

//HuaWei实现
class HuaWei implements Brand {
    @Override
    public void call() {
        System.out.println("HuaWei 开机");
    }
}

//XiaoMI实现
class XiaoMI implements Brand {
    @Override
    public void call() {
        System.out.println("XiaoMI 开机");
    }
}

abstract class Phone {
    //聚合Brand接口
    private Brand brand;

    //构造器：被子类调用
    public Phone(Brand brand) {
        this.brand = brand;
    }

    //定义手机功能，调用品牌的具体实现
    //注意该方法应该定义为protected，因为该方法还没有完成，还需要子类的填充，所以不能被调用
    protected void call() {
        brand.call();
    }
}

class FolderPhone extends Phone {
    //调用父类构造器，完成品牌手机的聚合
    public FolderPhone(Brand brand) {
        super(brand);
    }

    //重写父类的call，调用父类的call方法，即保留品牌手机的操作，再加上样式的特点，完成手机的功能实现
    @Override
    public void call() {
        super.call();
        System.out.println("添加了折叠手机的特色");
    }
}

class FullScreen extends Phone {
    //调用父类构造器，完成品牌手机的聚合
    public FullScreen(Brand brand) {
        super(brand);
    }

    //重写父类的call，调用父类的call方法，即保留品牌手机的操作，再加上样式的特点，完成手机的功能实现
    @Override
    public void call() {
        super.call();
        System.out.println("添加了全面平的特色");
    }

    public static void main(String[] args) {
        Phone phone = new FolderPhone(new Vivo());
        phone.call();
    }
}