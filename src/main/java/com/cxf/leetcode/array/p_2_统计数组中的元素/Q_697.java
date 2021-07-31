package com.cxf.leetcode.array.p_2_统计数组中的元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q_697 {
    public static void main(String[] args) throws Exception {
        System.out.println(findShortestSubArray3(new int[]{1, 2, 2, 3, 1, 4, 2}));

    }

    //纯暴力，通过不了LeetCode
    public static int findShortestSubArray(int[] nums) {
        int len = nums.length;
        int du = getDu(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int[] subArr = Arrays.copyOfRange(nums, i, j);
                if (du == getDu(subArr)) {
                    len = Math.min(len, subArr.length);
                }
            }
        }
        return len;
    }

    public static int getDu(int[] nums) {
        int du = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
            du = Math.max(du, hashMap.get(num));
        }
        return du;
    }

    //哈希法
    public static int findShortestSubArray2(int[] nums) {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        // 哈希表value存放int数组，0存放度（出现次数），1、2分别存放当前元素最左（第一次出现）、最右（最后一次出现）位置
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i])[0]++;
                hashMap.get(nums[i])[2] = i;
            } else {
                hashMap.put(nums[i], new int[]{1, i, i});
            }
        }

        int d = 0, minLen = 0;
        //循环哈希表，选出最大的度（即也是源数组出现最多次的数），然后根据最左最右位置计算得出子串长度
        for (Map.Entry<Integer, int[]> entry : hashMap.entrySet()) {
            int[] value = entry.getValue();
            if (d < value[0]) {
                d = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (d == value[0]) {
                if (minLen > value[2] - value[1] + 1) {
                    minLen = value[2] - value[1] + 1;
                }
            }
        }
        return minLen;
    }

    //比较好理解的哈希法
    public static int findShortestSubArray3(int[] nums) {
        int d = 0, minLen = nums.length;
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i])[0]++;
                hashMap.get(nums[i])[2] = i;
            } else {
                hashMap.put(nums[i], new int[]{1, i, i});
            }
            //存放哈希表的时候拿到最大度
            d = Math.max(d, hashMap.get(nums[i])[0]);
        }

        for (int[] value : hashMap.values()) {
            if (d == value[0]) {
                minLen = Math.min(minLen, value[2] - value[1] + 1);
            }
        }
        return minLen;
    }
}
