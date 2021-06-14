package com.cxf.leetcode.array.p_1_traversal;

public class Q_628 {
    public static void main(String[] args) throws Exception {
        System.out.println(maximumProduct(new int[]{1000, 1000, 1000}));

    }

    /**
     * 求数组中能组成最大乘积的三个元素，
     * 1）不存在负数，取前3大的元素乘积
     * 2）存在负数，要么取前3大的元素乘积，要么取前2小和前1大元素乘积
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        long minValue = -10000000000L;
        long maxValue = 10000000000L;
        long firstMax = minValue, secondMax = minValue, thirdMax = minValue;
        long firstMin = maxValue, secondMin = maxValue;
        for (int item : nums) {
            if (item >= firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = item;
            } else if (item >= secondMax && item < firstMax) {
                thirdMax = secondMax;
                secondMax = item;
            } else if (item >= thirdMax && item < secondMax) {
                thirdMax = item;
            }

            if (item <= firstMin) {
                secondMin = firstMin;
                firstMin = item;
            } else if (item <= secondMin && item > firstMin) {
                secondMin = item;
            }
        }

        firstMax = firstMax == minValue ? 1L : firstMax;
        secondMax = secondMax == minValue ? 1L : secondMax;
        thirdMax = thirdMax == minValue ? 1L : thirdMax;

        firstMin = firstMin == maxValue ? 1L : firstMin;
        secondMin = secondMin == maxValue ? 1L : secondMin;
        return (int) Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
    }
}
