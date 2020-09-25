package com.cxf.algorithm.seach;

/**
 * 插值查找（要求数组是有序的）
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 15, 44, 99, 705, 998, 1022, 2000};
        System.out.println(search(arr, 0, arr.length - 1, 998));
    }

    public static int search(int[] arr, int left, int right, int tag) {
        if (left > right) {
            return -1;
        }
        //神奇的算法公式
        int mid = left + (right - left) * (tag - arr[left]) / (arr[right] - arr[left]);
        if (tag > arr[mid]) {
            return search(arr, mid + 1, right, tag);
        }
        if (tag < arr[mid]) {
            return search(arr, left, mid - 1, tag);
        }

        return mid;
    }
}
