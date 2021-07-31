package com.cxf.leetcode.array.p_3_数组的改变移动;

public class Q_665 {
    public static void main(String[] args) throws Exception {
        System.out.println(checkPossibility(new int[]{1, 4, 1, 2}));
    }

    //遍历，保持非递减数列（保持的方法有2种，根据情况选择最优），直到结束返回答案
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                if (++count > 1) return false;
            }
        }
        return true;
    }
}
