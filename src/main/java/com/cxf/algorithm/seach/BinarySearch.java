package com.cxf.algorithm.seach;

/**
 * 二分查找（要求数组是有序的）
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 15, 44, 99, 705, 998, 1022, 2000};
        System.out.println(search(arr, 0, arr.length - 1, 199));
    }

    public static int search(int[] arr, int left, int right, int tag) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (tag > arr[mid]) {
            return search(arr, mid + 1, right, tag);
        }
        if (tag < arr[mid]) {
            return search(arr, left, mid - 1, tag);
        }

        return mid;
    }
}
