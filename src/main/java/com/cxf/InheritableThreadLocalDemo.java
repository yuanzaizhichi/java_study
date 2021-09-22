package com.cxf;

public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        threadLocal.set("父类数据：ThreadLocal");
        inheritableThreadLocal.set("父类数据：InheritableThreadLocal");

        new Thread(() -> {
            System.out.println("子线程获取父类数据：" + threadLocal.get());
            System.out.println("子线程获取父类数据：" + inheritableThreadLocal.get());
        }).start();

        //子线程获取父类数据：null
        //子线程获取父类数据：父类数据：InheritableThreadLocal
    }
}
