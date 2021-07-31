package com.cxf.leetcode.array.p_2_统计数组中的元素;

import java.util.Arrays;

public class Q_274 {
    public static void main(String[] args) throws Exception {
        System.out.println(hIndex(new int[]{100}));
        System.out.println(hIndex(new int[]{1, 3, 1}));
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    //线性判断
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i)
            i++;
        return i;
    }
}
