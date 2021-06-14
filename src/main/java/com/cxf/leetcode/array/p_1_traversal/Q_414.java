package com.cxf.leetcode.array.p_1_traversal;

public class Q_414 {
    public static void main(String[] args) throws Exception {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }

    //一次遍历
    public static int thirdMax(int[] nums) {
        long minValue = -10000000000L;
        long firstMax = minValue, secondMax = minValue, thirdMax = minValue;
        for (int item : nums) {
            if (item > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = item;
            } else if (item > secondMax && item < firstMax) {
                thirdMax = secondMax;
                secondMax = item;
            } else if (item > thirdMax && item < secondMax) {
                thirdMax = item;
            }
        }
        if (thirdMax > minValue) return (int) thirdMax;
        return (int) firstMax;
    }
}
