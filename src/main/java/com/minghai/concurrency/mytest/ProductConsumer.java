package com.minghai.concurrency.mytest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author minghai
 * @description 生产者消费者模型
 * @date 2019/11/27
 */
public class ProductConsumer {

    private static AtomicInteger count = new AtomicInteger(0);
    static final BlockingQueue<Baozi> blockingQueue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        ProductConsumer outClass = new ProductConsumer();
        System.out.println(blockingQueue.size());
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(outClass.new Producter());
        executor.execute(outClass.new Consumer());
        executor.execute(outClass.new Producter());
        executor.execute(outClass.new Consumer());
        executor.execute(outClass.new Producter());
        executor.execute(outClass.new Consumer());
    }

    class Consumer implements  Runnable{
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                   if(blockingQueue.size() != 0){
                       synchronized (blockingQueue){
                           Baozi baozi = blockingQueue.take();
                           System.out.println(Thread.currentThread().getName()
                                   +" 顾客吃"+baozi.name+"包子，目前还有 " + blockingQueue.size());
                       }
                   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producter implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    if(blockingQueue.size() != 10){
                        synchronized (blockingQueue){
                            blockingQueue.put(new Baozi("韭菜馅"));
                            System.out.println(Thread.currentThread().getName()
                                    +" 包子铺做包子，目前还有 " + blockingQueue.size());
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class Baozi{
    String name;

    public Baozi(String name) {
        this.name = name;
    }
}
