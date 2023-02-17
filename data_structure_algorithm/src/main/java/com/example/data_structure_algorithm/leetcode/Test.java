package com.example.data_structure_algorithm.leetcode;

/**
 * @Author: sidao.zhu
 * @Date: 2022/2/14
 */
public class Test {

    synchronized void say(){
        System.out.println("it will wait");
        while( 1==1){
            System.out.println(11);
        }
        //System.out.println("wake");
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread thread = new Thread(() -> {
                test.say();
        });
        thread.start();

/*
        new Thread(()->{
            try {
                test.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
*/
        Thread.sleep(2000L);
        thread.interrupt();
/*        synchronized (test){
            test.notify();
            Thread.sleep(3000L);
        }*/
    }
}
