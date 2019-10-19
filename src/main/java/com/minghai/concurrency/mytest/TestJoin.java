package com.minghai.concurrency.mytest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TestJoin {

    private static LongAdder longAdder = new LongAdder();
    private  static int a = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i= 0; i < 5; i++){
                    add();
                }
            }
        };

        t1.start();

        t1.join();

        System.out.println(longAdder.intValue() + " \t" + a);


    }

    public static void add(){
        longAdder.increment();
        a++;
    }
}
