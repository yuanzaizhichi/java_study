package com.cxf.part10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " is over ");
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " is over ");
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            System.out.println("waiting all child thread over");
            semaphore.acquire(2);
            System.out.println("all child thread is over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
