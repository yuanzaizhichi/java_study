package com.cxf.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // 一趟快排，并返回交换后基数的下标
            int index = patition(arr, l, r);
            // 递归排序基数左边的数组
            sort(arr, l, index - 1);
            // 递归排序基数右边的数组
            sort(arr, index + 1, r);
        }
    }

    public static int patition(int[] arr, int l, int r) {
        //每次排序选择最左边的元素为基数
        int p = arr[l];
        int i = l;
        int j = r;
        //直到i、j相遇
        while (i < j) {
            // 从右往左找第一个小于基数的数
            while (arr[j] >= p && j > i) {
                j--;
            }

            // 从左往右找第一个大于基数的数
            while (arr[i] <= p && j > i) {
                i++;
            }
            // 找到后交换两个数
            swap(arr, i, j);
        }
        // 使划分好的数分布在基数两侧
        swap(arr, l, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
