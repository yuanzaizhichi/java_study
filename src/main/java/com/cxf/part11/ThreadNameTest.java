package com.cxf.part11;

public class ThreadNameTest {
    static final String THREAD_SAVE_ORDER = "THREAD_SAVE_ORDER";
    static final String THREAD_SAVE_ADDR = "THREAD_SAVE_ADDR";

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            System.out.println("保存订单线程");
            throw new NullPointerException();
        }, THREAD_SAVE_ORDER);

        Thread thread2 = new Thread(() -> {
            System.out.println("保存地址线程");
        }, THREAD_SAVE_ADDR);

        thread1.start();
        thread2.start();
    }
}
