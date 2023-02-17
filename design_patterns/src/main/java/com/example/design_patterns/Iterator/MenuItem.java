package com.example.design_patterns.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 定义：迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。
 * <p>
 * 把游走的任务放在迭代器上，而不是聚合上，这样简化了聚合的接口和实现，而也让责任各得其所
 * <p>
 * 只支持一组功能的时候称为高类聚
 *
 * @author ZhuSiDao
 * @date 2020/11/24
 */

public class MenuItem {
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}

class DinerMenu implements Iterable<MenuItem> {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Diner1", "Diner1", true, 1.9);
        addItem("Diner2", "Diner2", false, 2.9);
        addItem("Diner3", "Diner3", true, 3.9);
        addItem("Diner4", "Diner4", true, 4.9);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems += 1;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new DinerMenuIterator(menuItems);
    }
}

/**
 * 迭代器
 */
class DinerMenuIterator implements Iterator<MenuItem> {

    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public MenuItem next() {
        return menuItems[position++];
    }
}

class PancakeHouseMenu implements Iterable<MenuItem> {

    List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("Pancake1", "Pancake1", true, 1.99);
        addItem("Pancake2", "Pancake2", false, 2.99);
        addItem("Pancake3", "Pancake3", true, 3.99);
        addItem("Pancake4", "Pancake4", true, 4.99);

    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    Iterator<MenuItem> createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}

/**
 * 迭代器
 */
class PancakeHouseMenuIterator implements Iterator<MenuItem> {

    List<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }

    @Override
    public MenuItem next() {
        return menuItems.get(position);
    }
}


