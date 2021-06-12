package com.cxf.leetcode.other;

import java.util.HashMap;

public class Q_1 {
    public static void main(String[] args) throws Exception {
        Solution2 solution = new Solution2();
        int[] ints = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] + nums[i1] == target) return new int[]{i, i1};
            }
        }
        return new int[2];
    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[2];
    }
}
