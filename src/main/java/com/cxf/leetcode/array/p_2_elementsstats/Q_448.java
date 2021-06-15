package com.cxf.leetcode.array.p_2_elementsstats;

import java.util.*;

public class Q_448 {
    public static void main(String[] args) throws Exception {
        System.out.println(findDisappearedNumbers3(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers3(new int[]{1, 1}));
    }

    //暴力循环，不能通过LeetCode
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            boolean flag = false;
            for (int num : nums) {
                if (num == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) lst.add(i);
        }
        return lst;
    }

    //set集合，去重存放在set
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) lst.add(i);
        }
        return lst;
    }

    //原地修改数组
    //因为数组内元素都在[1,n]内，遍历数组，找到元素原本的索引，并将索引上的元素变成负数
    //第二次循环，i索引上的元素不为负数，则数组缺少i+1这个数字
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
