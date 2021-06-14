package com.cxf.leetcode.array.p_2_elementsstats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q_645 {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(findErrorNums3(new int[]{1, 3, 3, 4})));
    }

    //暴力法：逐一比对，找到后跳出
    public static int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1, count = 0;
        for (int i = 1; i <= nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]) count++;
            }
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                missing = i;
            }
            if (dup > 0 && missing > 0) break;
        }
        return new int[]{dup, missing};
    }

    //排序法：排序后，重复的元素便在一起，相邻元素差大于1的便是缺失的元素
    public static int[] findErrorNums2(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        //这种方式无法检测出最后一个元素是缺失元素，所以只能加上判断
        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

    //使用哈希表
    public static int[] findErrorNums3(int[] nums) {
        int dup = -1, missing = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        for (int num = 1; num <= nums.length; num++) {
            if (hashMap.containsKey(num)) {
                if (hashMap.get(num) == 2) dup = num;
                continue;
            }
            missing = num;
        }
        return new int[]{dup, missing};
    }

    //使用哈希表
    public static int[] findErrorNums4(int[] nums) {
        int num = 0, sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) num = nums[i];
            else hashMap.put(nums[i], 1);
            sum += nums[i];
        }

        return new int[]{num, num - (sum - (1 + nums.length) * nums.length / 2)};
    }
}
