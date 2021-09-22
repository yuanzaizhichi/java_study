package com.cxf.leetcode.array.p_8_前缀和数组;

public class Q_303 {
    public static void main(String[] args) {

    }

    /**
     * 解法: 前缀和，arr[i]存放前面i个元素之和
     * 时间复杂度: T(n) = O(n)
     * 空间复杂度: S(n) = O(n)
     */
    class NumArray {
        int[] arr;

        public NumArray(int[] nums) {
            int length = nums.length;
            arr = new int[length + 1];
            for (int i = 0; i < length; i++) {
                arr[i + 1] = arr[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return arr[right + 1] - arr[left];
        }
    }
}
