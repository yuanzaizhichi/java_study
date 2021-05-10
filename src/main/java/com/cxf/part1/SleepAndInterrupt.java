package com.cxf.part1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepAndInterrupt {


    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            try {
                System.out.println("threadA is in sleep");
                Thread.sleep(10000);
                System.out.println("threadA is awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        Thread.sleep(2000);
        threadA.interrupt();
    }
}
