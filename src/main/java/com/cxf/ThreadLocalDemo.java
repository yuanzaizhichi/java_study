package com.cxf;

import java.text.SimpleDateFormat;

public class ThreadLocalDemo implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        ThreadLocalDemo threadLocal = new ThreadLocalDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadLocal);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("thread name : " + Thread.currentThread().getName() + " ; default format : " + LOCAL.get().toPattern());
        LOCAL.set(new SimpleDateFormat());
        System.out.println("thread name : " + Thread.currentThread().getName() + " ; change format : " + LOCAL.get().toPattern());
        System.out.println("thread name : " + Thread.currentThread().getName() + " ; change format : " + LOCAL.get().toPattern());
    }
    //thread name : Thread-1 ; default format : yyyy-MM-dd HH:mm:ss
    //thread name : Thread-0 ; default format : yyyy-MM-dd HH:mm:ss
    //thread name : Thread-2 ; default format : yyyy-MM-dd HH:mm:ss
    //thread name : Thread-1 ; change format : y/M/d ah:mm
    //thread name : Thread-3 ; default format : yyyy-MM-dd HH:mm:ss
    //thread name : Thread-4 ; default format : yyyy-MM-dd HH:mm:ss
    //thread name : Thread-2 ; change format : y/M/d ah:mm
    //thread name : Thread-0 ; change format : y/M/d ah:mm
    //thread name : Thread-4 ; change format : y/M/d ah:mm
    //thread name : Thread-3 ; change format : y/M/d ah:mm
}
