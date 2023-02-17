package com.example.data_structure_algorithm.jike.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: sidao.zhu
 * @Date: 2021/3/9
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "123";
            }
        });
        new Thread(futureTask).start();
        futureTask.get();
        System.out.println(futureTask.isDone());

    }
}
