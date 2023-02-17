package com.example.juc.threadpool;

public class Do {
	public static void main(String[] args ) {
		MyThread thread=new MyThread();
		thread.start();
		thread.interrupt();
		System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted());
		System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted());
                    //测试interrupted（）函数
		System.out.println("第一次调用thread.interrupted()："+thread.interrupted());
		System.out.println("第二次调用thread.interrupted()："+thread.interrupted());
		System.out.println("thread是否存活："+thread.isAlive());
	}
}

