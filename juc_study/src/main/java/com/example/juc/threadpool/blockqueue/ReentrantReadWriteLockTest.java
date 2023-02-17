package com.example.juc.threadpool.blockqueue;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: sidao.zhu
 * @Date: 2021/4/14
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        Scanner sc = new Scanner(System.in);
        new Thread(() -> {
            readWriteLock.writeLock().lock();
            while ("1".equals(sc.nextLine())) {
                readWriteLock.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {
            readWriteLock.readLock().lock();
            while ("2".equals(sc.nextLine())) {
                readWriteLock.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            readWriteLock.readLock().lock();
            while ("3".equals(sc.nextLine())) {
                readWriteLock.readLock().unlock();
            }
        }).start();
    }
}
