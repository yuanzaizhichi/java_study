package com.cxf.part10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownlatchTest {
    private static volatile CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    latch.countDown();
                    System.out.println(Thread.currentThread().getName() + " is over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    latch.countDown();
                    System.out.println(Thread.currentThread().getName() + " is over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            System.out.println("waiting all child thread over");
            latch.await();
            System.out.println("all child is over");
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}