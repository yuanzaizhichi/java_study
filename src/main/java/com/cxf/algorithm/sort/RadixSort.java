package com.cxf.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序(经典空间换时间)
 */
public class RadixSort {


    public static void main(String[] args) {
        //以下为推导过程
        int[] arr = {46, 1, 8, 9, 15, 233, 566};
        //桶数组
        int[][] bucket = new int[10][arr.length];
        //各桶数量记录数组（用来记录每个桶放置了多少个元素,bucketElementCount[2] = 第三个桶放置元素的数量）
        int[] bucketElementCount = new int[10];

        sort(arr);

//         /**
//         * 根据个位数放置
//         */
//        for (int i = 0; i < arr.length; i++) {
//            //拿到个位数
//            int digitOfElement = arr[i] % 10;
//            //与桶数组比较，确定放置位置
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
//            //放置元素的桶数量+1
//            bucketElementCount[digitOfElement]++;
//        }
//        int count = 0;
//        //按顺序从桶中取出元素，替换原数组
//        for (int i = 0; i < bucket.length; i++) {
//            if (bucketElementCount[i] != 0) {
//                for (int j = 0; j < bucketElementCount[i]; j++) {
//                    arr[count] = bucket[i][j];
//                    count++;
//                }
//                //清空各桶数量记录数组，用于下次放置
//                bucketElementCount[i] = 0;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        /**
//         * 根据十位数放置
//         */
//        for (int i = 0; i < arr.length; i++) {
//            //拿到十位数
//            int digitOfElement = arr[i] / 10 % 10;
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
//            bucketElementCount[digitOfElement]++;
//        }
//        count = 0;
//        for (int i = 0; i < bucket.length; i++) {
//            if (bucketElementCount[i] != 0) {
//                for (int j = 0; j < bucketElementCount[i]; j++) {
//                    arr[count] = bucket[i][j];
//                    count++;
//                }
//                bucketElementCount[i] = 0;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        /**
//         * 根据百位数放置
//         */
//        for (int i = 0; i < arr.length; i++) {
//            //拿到百位数
//            int digitOfElement = arr[i] / 100 % 10;
//            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
//            bucketElementCount[digitOfElement]++;
//        }
//        count = 0;
//        for (int i = 0; i < bucket.length; i++) {
//            if (bucketElementCount[i] != 0) {
//                for (int j = 0; j < bucketElementCount[i]; j++) {
//                    arr[count] = bucket[i][j];
//                    count++;
//                }
//                bucketElementCount[i] = 0;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];

        //得到最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //得到数组中最大的数有几位
        int digitsNum = ("" + max).length();

        for (int z = 0, x = 1; z < digitsNum; z++, x *= 10) {
            for (int i = 0; i < arr.length; i++) {
                //拿到个位数
                int digitOfElement = arr[i] / x % 10;
                //与桶数组比较，确定放置位置
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
                //放置元素的桶数量+1
                bucketElementCount[digitOfElement]++;
            }
            int count = 0;
            //按顺序从桶中取出元素，替换原数组
            for (int i = 0; i < bucket.length; i++) {
                if (bucketElementCount[i] != 0) {
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        arr[count] = bucket[i][j];
                        count++;
                    }
                    //清空各桶数量记录数组，用于下次放置
                    bucketElementCount[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
