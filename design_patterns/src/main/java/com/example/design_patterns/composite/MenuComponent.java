package com.example.design_patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式允许你将对象组合成树形接口来表现"整体/部分"层次结构。组合能让客户已一致的方式处理个别对象以及对象组合。
 * <p>
 * 使用组合结构，我们能把相同的操作应用在组合和个别对象上。换句话说，在大多数情况下，我们可以忽略对象组合和个别对象之间的差别。
 *
 * @author ZhuSiDao
 * @date 2020/11/24
 */
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancake house menu", "breakfast");
        MenuComponent lunchMenu = new Menu("lunch menu", "lunch");
        MenuComponent dinerMenu = new Menu("dinner menu", "dinner");
        MenuComponent dessertMenu = new Menu("dessert menu", "dessert");

        MenuComponent allMenus = new Menu("all menus", "all menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(lunchMenu);
        allMenus.add(dinerMenu);

        dinerMenu.add(new MenuItem("pasta", "spaghtti", true, 3.89));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("apple pie", "apple", true, 1.59));

        allMenus.print();
    }
}

class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.print(" " + getPrice());
        System.out.println(" ---" + getDescription());
    }
}

class Menu extends MenuComponent {
    List<MenuComponent> menuComponentList = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponentList.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print(getName());
        System.out.println(getDescription());
        System.out.println("-------------------");
        menuComponentList.forEach(MenuComponent::print);
    }
}