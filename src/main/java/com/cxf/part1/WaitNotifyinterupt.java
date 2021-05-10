package com.cxf.part1;

public class WaitNotifyinterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(1000);

        threadA.start();
        threadA.interrupt();
    }
}
