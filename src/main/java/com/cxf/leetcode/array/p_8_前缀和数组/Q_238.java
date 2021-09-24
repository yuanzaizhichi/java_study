package com.cxf.leetcode.array.p_8_前缀和数组;

import java.util.Arrays;

public class Q_238 {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1, 2, 3, 4});
        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     * 解法: 前缀法：构建2个前缀数组，L[i]放置nums[i]所有左边元素的乘积，R[i]放置所有右边元素的乘积，计算L[i] * R[i]即可
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(n)
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] arr = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            arr[i] = L[i] * R[i];
        }
        return arr;
    }
}
