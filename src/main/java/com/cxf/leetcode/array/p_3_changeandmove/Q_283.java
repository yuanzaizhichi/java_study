package com.cxf.leetcode.array.p_3_changeandmove;

import java.util.Arrays;

public class Q_283 {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{0, 1, 0, 3, 12, 7, 1, 3, 0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    //遍历数组->遇到0：增加0的个数;遇到非0:根据0的个数进行元素交换，直到结束
    public static void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ++zeroCount;
            } else {
                if (zeroCount > 0) {
                    int temp = nums[i];
                    nums[i] = 0;
                    nums[i - zeroCount] = temp;
                }
            }
        }
    }
}
