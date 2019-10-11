package com.minghai.concurrency.singleton;

import com.minghai.concurrency.annotation.NotRecommend;
import com.minghai.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有的构造函数
    private SingletonExample3(){

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    public synchronized static SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
