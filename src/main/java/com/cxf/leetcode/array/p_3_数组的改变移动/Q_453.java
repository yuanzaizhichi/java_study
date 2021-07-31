package com.cxf.leetcode.array.p_3_数组的改变移动;

import java.util.Arrays;

public class Q_453 {
    public static void main(String[] args) throws Exception {
        System.out.println(minMoves3(new int[]{1, 2, 3}));
        System.out.println(minMoves3(new int[]{2, 4, 5}));
        System.out.println(minMoves3(new int[]{1, 5, 6}));
        System.out.println(minMoves3(new int[]{1, 3, 4, 5}));
    }

    //暴力法（超时）：每次循环给除最大值的元素的加一，直到最小值和最大值相等
    public static int minMoves(int[] nums) {
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[len - 1]) {
            for (int i = 0; i < len - 1; i++) {
                nums[i]++;
            }
            Arrays.sort(nums);
            count++;
        }
        return count;
    }

    //暴力法改进（超时）：每次循环给除最大值的元素的加最大值与最小值的差，直到最小值和最大值相等
    public static int minMoves2(int[] nums) {
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[len - 1]) {
            int diff = nums[len - 1] - nums[0];
            for (int i = 0; i < len - 1; i++) {
                nums[i] += diff;
            }
            Arrays.sort(nums);
            count += diff;
        }
        return count;
    }

    /**
     * 利用排序，寻得规律，最小值与其余值的差之和便是答案
     *
     * @param nums
     * @return
     */
    public static int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

}
