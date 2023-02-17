package com.example.juc.threadpool.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: sidao.zhu
 * @Date: 2021/4/9
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    arrayBlockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
