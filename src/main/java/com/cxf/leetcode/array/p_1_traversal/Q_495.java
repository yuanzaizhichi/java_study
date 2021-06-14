package com.cxf.leetcode.array.p_1_traversal;

public class Q_495 {
    public static void main(String[] args) throws Exception {
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }

    //一次遍历
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        //遍历中防止溢出没有取最后一个元素，已知最后一次中毒一定持续duration，故在此加上
        return res + duration;
    }
}
