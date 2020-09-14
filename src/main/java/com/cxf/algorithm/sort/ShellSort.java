package com.cxf.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = {2, 6, 8, 1, 7, 3, 4, 0, -8, -3};
        shellSort2(arr);

    }

    /**
     * 交换法
     *
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        //放交换值的工具人
        int temp;
        //排序次数
        int count = 0;

        //增量gap，并逐步缩小增量（是分组情况，也是每组步长）
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //循环每组
            for (int i = gap; i < arr.length; i++) {
                //组内进行循环交换排序
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + (++count) + "次排序: " + Arrays.toString(arr));
        }
    }

    /**
     * 移位法
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        int temp;
        int j;
        int count = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //循环每组，组内进行插入排序
            for (int i = gap; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && arr[j - gap] > temp) {
                        //在有序组里，向前移动，向前移动的跨度也应该调整为gap
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出while循环，找到自己的位置
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (++count) + "次排序: " + Arrays.toString(arr));
        }
    }
}
