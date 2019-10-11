package com.minghai.concurrency.singleton;

import com.minghai.concurrency.annotation.NotThreadSafe;
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
public class SingletonExample2 {

    // 私有的构造函数
    private SingletonExample2(){

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
