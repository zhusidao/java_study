package com.example.juc.threadpool;

public class MyThread extends Thread {
    @Override
    public  void run() {
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            System.out.println("i had interrupted");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000L);
        myThread.interrupt();
    }
}