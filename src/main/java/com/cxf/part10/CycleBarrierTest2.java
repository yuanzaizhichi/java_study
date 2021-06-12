package com.cxf.part10;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycleBarrierTest2 {
    private static CyclicBarrier countDown = new CyclicBarrier(2, () -> System.out.println(Thread.currentThread() + " merge result"));

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " step1 ");
                countDown.await();

                System.out.println(Thread.currentThread() + " step2 ");
                countDown.await();

                System.out.println(Thread.currentThread() + " step3 ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " step1 ");
                countDown.await();

                System.out.println(Thread.currentThread() + " step2 ");
                countDown.await();

                System.out.println(Thread.currentThread() + " step3 ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
