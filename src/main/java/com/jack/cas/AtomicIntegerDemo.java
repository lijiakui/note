package com.jack.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: LiJiakui
 * @Description: AtomicInteger 原子操作
 * @Dat: Create in 17:55 2019-12-19
 * @Modifiled By:
 */
public class AtomicIntegerDemo {
    AtomicInteger atomicInteger = new AtomicInteger();
    int i = 0;

    public void add() {
        atomicInteger.incrementAndGet();
    }
    public static void main(String[] args) {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        for (int i = 20; i > 0; i--) {
            new Thread(() -> {
                for (int i1 = 1000; i1 > 0; i1--) {
                    demo.add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(demo.atomicInteger.get());
    }
}
