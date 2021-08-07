package com.cxf.leetcode.array.p_5_数组旋转;

import java.util.Arrays;

public class Q_189 {
    public static void main(String[] args) throws Exception {
        int[] nums = {-1};
        Arrays.stream(nums).forEach(System.out::print);
        rotate2(nums, 2);
        System.out.println("");
        Arrays.stream(nums).forEach(System.out::print);
    }

    /**
     * 解法: 额外数组
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(n)
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] arrRes = new int[length];
        for (int i = 0; i < length; i++) {
            arrRes[(i + k) % length] = nums[i];
        }
        System.arraycopy(arrRes, 0, nums, 0, length);
    }

    /**
     * 解法: 翻转数组
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(1)
     */
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    //翻转数组
    public static void reverse(int[] arr, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
