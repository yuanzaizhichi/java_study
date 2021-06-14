package com.cxf.part11;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestSimpleDateFormat {

    static ThreadLocal<DateFormat> local = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(local.get().parse("2012-09-22 14:07:45"));
                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    local.remove();
                }
            });
            thread.start();
        }
    }
}
