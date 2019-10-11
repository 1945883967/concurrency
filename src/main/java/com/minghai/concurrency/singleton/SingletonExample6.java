package com.minghai.concurrency.singleton;

import com.minghai.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 *
 * 使用饿汉模式时要注意两个问题：
 *      1.私有的构造函数在实现时没有太多的处理
 *      2.这个类在实际的过程中肯定会被使用，避免资源的浪费
 */
@ThreadSafe
public class SingletonExample6 {

    static{
        instance = new SingletonExample6();
    }

    // 单例对象
    private static SingletonExample6 instance = null;

    // 私有的构造函数
    private SingletonExample6(){

    }


    // 静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
