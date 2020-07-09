package com.cxf.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Sha1Demo {
    public static void main(String[] args) {
        long time = System.currentTimeMillis() / 1000;
        System.out.println(time);
        System.out.println(DigestUtils.sha1Hex("QWHHJEY4vbPy2B5IDG0AF6Q8gNSti43QVzCYhkMlajNDL68sVIp6" + time));
    }
}
