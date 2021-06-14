package com.cxf.leetcode.array.p_1_traversal;

public class Q_485 {
    public static void main(String[] args) throws Exception {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    //一次遍历
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0, currNum = 0;
        for (int num : nums) {
            if (num == 1) {
                currNum++;
                continue;
            }
            maxNum = Math.max(currNum, maxNum);
            currNum = 0;
        }
        //解决最后一个元素是1的情况
        maxNum = Math.max(currNum, maxNum);
        return maxNum;
    }
}
