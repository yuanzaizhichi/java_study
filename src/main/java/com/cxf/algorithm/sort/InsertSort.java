package com.cxf.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -20};

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            //无序组的第一个，从后往前跟有序组对比，对比过程中，有序组后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;

            System.out.println(Arrays.toString(arr));
        }
    }
}
