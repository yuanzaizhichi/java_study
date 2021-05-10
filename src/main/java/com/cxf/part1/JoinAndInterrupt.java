package com.cxf.part1;

public class JoinAndInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            System.out.println("child threadA is running");
            for (; ; ) {

            }
        });

        Thread mainThread = Thread.currentThread();

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainThread.interrupt();
        });

        threadA.start();
        threadB.start();
        threadA.join();
    }
}
