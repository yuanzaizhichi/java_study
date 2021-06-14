package com.cxf.part11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    static ConcurrentHashMap<String, List<String>> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("test1");
            list1.add("test2");
            List<String> list11 = hashMap.putIfAbsent("list1", list1);
            if (list11 != null) list11.addAll(list1);

            System.out.println(hashMap);
        });

        Thread thread2 = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("test11");
            list1.add("test22");
            List<String> list11 = hashMap.putIfAbsent("list1", list1);
            if (list11 != null) list11.addAll(list1);

            System.out.println(hashMap);
        });

        Thread thread3 = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("test111");
            list1.add("test222");
            List<String> list11 = hashMap.putIfAbsent("list2", list1);
            if (list11 != null) list11.addAll(list1);

            System.out.println(hashMap);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
