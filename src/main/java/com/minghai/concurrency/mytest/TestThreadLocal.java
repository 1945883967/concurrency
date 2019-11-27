package com.minghai.concurrency.mytest;

public class TestThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("minghai");

        System.out.println(threadLocal.get());
    }
}
