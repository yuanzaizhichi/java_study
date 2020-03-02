package com.cxf.test;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

        Optional<String> reduce = stringList.stream()
                .sorted()
                .reduce((a, b) -> a + "#" + b);
        reduce.ifPresent(System.out::println);
    }
}
