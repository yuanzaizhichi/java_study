package com.cxf.leetcode.desginmodel;

public class Singleton extends Object {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private void Singleton() {
    }

    /*
     * 初始化类的操作是线程安全的，保证了线程安全性
     * 实例使用static修饰，保证了唯一性
     * 由于是内部类，在未调用getInstance方法前，SingletonHolder不会初始化，使其具有延迟性
     */
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);


        //com.cxf.leetcode.desginmodel.Singleton@56ac3a89
        //com.cxf.leetcode.desginmodel.Singleton@56ac3a89
        //true
    }
}
