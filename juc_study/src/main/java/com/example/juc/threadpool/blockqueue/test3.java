package com.example.juc.threadpool.blockqueue;

public class test3 {
    public static void main(String[] args){
        Thread.currentThread().interrupt();
        try {
            Thread.sleep(1000);  // 消耗掉中断状态后，抛出异常
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
