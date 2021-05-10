package com.cxf.part1;

public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> System.out.println("child threadA is over"));

        Thread threadB = new Thread(() -> System.out.println("child threadB is over"));

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main thread is over");
    }
}
