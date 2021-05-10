package com.cxf.part1;

public class NotifyAndNotifyAll {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");

                    System.out.println("threadA start wait");
                    resourceA.wait();
                    System.out.println("threadA end wait");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");

                    System.out.println("threadB start wait");
                    resourceA.wait();
                    System.out.println("threadB end wait");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadC get resourceA lock");

                System.out.println("threadC start notify");
                resourceA.notifyAll();
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);

        threadC.start();
    }
}
