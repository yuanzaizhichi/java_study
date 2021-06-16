package com.cxf.leetcode.array.p_2_elementsstats;

import java.util.ArrayList;
import java.util.List;

public class Q_442 {
    public static void main(String[] args) throws Exception {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{4, 3, 7, 7, 8, 8, 3, 1}));
    }

    //原地修改数组（与448差不多）
    //因为数组内元素都在[1,n]内，遍历数组，找到元素原本的索引，并将索引上的元素变成负数；若循环中遇到nums[index] < 0即为重复的数，加入list
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) list.add(Math.abs(nums[i]));
            nums[index] *= -1;
        }
        return list;
    }
}
