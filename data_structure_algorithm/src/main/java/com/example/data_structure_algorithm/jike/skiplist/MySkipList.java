package com.example.data_structure_algorithm.jike.skiplist;

import java.util.Arrays;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/21
 */
public class MySkipList {

    private static final float SKIPLIST_P = 0.5f;
    private Node head = new Node(LEVEL);

    private final static int LEVEL = 16;

    private int find(int val) {
        Node p = head;
        for (int i = LEVEL - 1; i >= 0; i--) {
            while (p.next != null && p.next[i].data < val) {
                p = p.next[i];
            }
        }
        if (p.next != null && p.next[0].data == val) {
            return val;
        }
        return -1;
    }

    private void insert(int val) {
        int randomLevel = randomLevel();
        Node p = head;
        Node newNode = new Node(randomLevel);
        newNode.data = val;
        for (int i = randomLevel - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < val) {
                p = p.next[i];
            }
            newNode.next[i] = p.next[i];
            p.next[i] = newNode;
        }
    }

/*    private void delete(int val) {
        Node p = head;
        Node[] updates = new Node[randomLevel];
        Arrays.fill(updates, head);
        Node[] newNode = new Node[randomLevel];
        Arrays.fill(newNode, head);
        for (int i = randomLevel - 1; i >= 0; i--) {
            while (p.next != null && val < p.next[i].data) {
                p = p.next[i];
            }
            updates[i] = p;
        }
        for (int i = randomLevel - 1; i >= 0; i--) {
            newNode[i].next = updates[i].next;
            updates[i].next = newNode;
        }
    }*/

    private void printFormat() {
        Node p = head;
        for (int i = 0; i < p.next.length; i++) {
            while (p.next != null && p.next[i] != null) {
                System.out.println("--------node[" + p.next[i].data + "]");
                p = p.next[i];
            }
            System.out.println();
        }
    }

    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < LEVEL) {
            level += 1;
        }
        return level;
    }


    public static void main(String[] args) {
        MySkipList mySkipList = new MySkipList();
        mySkipList.insert(1);
        mySkipList.insert(2);
        mySkipList.insert(3);
        mySkipList.insert(4);
        mySkipList.insert(5);
        mySkipList.insert(6);
        mySkipList.insert(7);
        mySkipList.insert(8);
        mySkipList.insert(9);
        mySkipList.insert(10);
        mySkipList.printFormat();
    }

    static class Node {
        protected int data = -1;

        protected Node[] next;

        public Node() {
        }

        public Node(int level) {
            this.next = new Node[level];
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node[] getNext() {
            return next;
        }

        public void setNext(Node[] next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + Arrays.toString(next) +
                    '}';
        }
    }
}
