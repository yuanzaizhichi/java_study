package com.cxf.leetcode.array.p_2_统计数组中的元素;

import java.util.HashMap;

public class Q_42 {
    public static void main(String[] args) throws Exception {
        System.out.println(firstMissingPositive2(new int[]{7, 8, 9, 11, 12}));
    }

    //哈希表
    public static int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) hashMap.put(num, num);
        for (int i = 1; ; i++) {
            if (!hashMap.containsKey(i)) return i;
        }
    }

    //修改原数组并标记（与442、448如出一辙）
    //缺失的第一个正整数，一定在[1,len+1]中，遍历数组，找到元素原本的索引，并将索引上的元素变成负数（标记，即存在），剩下第一个不是负数的便是缺失的第一个正整数
    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        //首先排除可能存在的负数的干扰，将负数全部变成len+1
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0)
                nums[i] = len + 1;
        }

        //遍历数组，找到元素原本的索引，并将索引上的元素变成负数（标记，即存在）
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len)
                nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        //遍历数组，nums[i]>0时，即i+1为未出现过的正整数，
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return len + 1;
    }

    //置换法，与标记法差不多，只是将不标记，而是将元素持续置换，置换后的数组中，[1,len+1]的数已经按顺序排序好，遍历查找便可return
    public static int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }

}
