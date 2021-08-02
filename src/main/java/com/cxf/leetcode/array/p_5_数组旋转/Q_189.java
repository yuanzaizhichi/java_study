package com.cxf.leetcode.array.p_5_数组旋转;

import java.util.Arrays;
import java.util.HashMap;

public class Q_189 {
    public static void main(String[] args) throws Exception {
        int[] nums = {-1, -100, 3, 99};
        Arrays.stream(nums).forEach(System.out::print);
        rotate(nums, 2);
        System.out.println("");
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void rotate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put((i + k) % length, nums[i]);
        }

        for (int i = 0; i < length; i++) {
            nums[i] = map.get(i);
        }
    }
}
