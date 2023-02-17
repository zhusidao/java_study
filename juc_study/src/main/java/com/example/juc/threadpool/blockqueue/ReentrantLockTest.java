package com.example.juc.threadpool.blockqueue;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: sidao.zhu
 * @Date: 2021/4/13
 */
public class ReentrantLockTest {
    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();  // block until condition holds
                try {
                    // ... method body
                    System.out.println(123);
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }

    public void lock() {
        lock.lock();  // block until condition holds
        try {
            // ... method body
            System.out.println(123);
        } finally {
            lock.unlock();
        }
    }
}
