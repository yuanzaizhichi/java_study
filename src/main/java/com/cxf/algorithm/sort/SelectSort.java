package com.cxf.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {300, 900, -19, -10, -20};
        //默认最小值
        int min = 0;
        //记录最小值下标
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (min != arr[i]) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
