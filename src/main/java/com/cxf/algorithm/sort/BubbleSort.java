package com.cxf.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
        int[] arr = {3, 9, -1, 10, 20};

        //交换变量
        int temp;
        //判断上一次是否进行了排序，若上次没有进行排序，证明排序已经提前完成，可提前跳出循环，结束排序
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "次排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}
