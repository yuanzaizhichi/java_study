package com.cxf.part1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sleep {

    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("threadA is in sleep");
                Thread.sleep(10000);
                System.out.println("threadA is awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("threadB is in sleep");
                Thread.sleep(10000);
                System.out.println("threadB is awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });

        threadA.start();
        threadB.start();
    }
}
