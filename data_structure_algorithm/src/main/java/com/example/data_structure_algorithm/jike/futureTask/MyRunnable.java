package com.example.data_structure_algorithm.jike.futureTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {
    private Integer index;

    public MyRunnable(Integer index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println(index);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable(i));
        }
        executorService.shutdown();
    }
}