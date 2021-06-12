package com.cxf.part10;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycleBarrierTest {
    private static CyclicBarrier countDown = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " task1 merge result");
        }
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " task1-1 ");
                System.out.println(Thread.currentThread() + " task1-1 enter in barrier");
                countDown.await();
                System.out.println(Thread.currentThread() + " task1-1 enter out barrier");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " task1-2 ");
                System.out.println(Thread.currentThread() + " task1-2 enter in barrier");
                countDown.await();
                System.out.println(Thread.currentThread() + " task1-2 enter out barrier");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
