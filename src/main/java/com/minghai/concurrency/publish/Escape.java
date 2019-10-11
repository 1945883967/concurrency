package com.minghai.concurrency.publish;

import com.minghai.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class Escape {

    private int thisCanEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanEscape);

        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
