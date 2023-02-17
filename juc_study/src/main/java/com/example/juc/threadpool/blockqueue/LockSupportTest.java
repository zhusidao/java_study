package com.example.juc.threadpool.blockqueue;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: sidao.zhu
 * @Date: 2021/4/14
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i=0;;i++){
                LockSupport.park();
            }

        });
        thread.start();
        Thread.sleep(2000L);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
       // thread.interrupt();
    }
}
