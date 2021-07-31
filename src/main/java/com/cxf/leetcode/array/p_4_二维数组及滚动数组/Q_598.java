package com.cxf.leetcode.array.p_4_二维数组及滚动数组;

public class Q_598 {
    public static void main(String[] args) {

    }

    /**
     * 解法: 拒绝暴力法
     * 根据题意，将二维数组摊开图，所有自增都会从0开始，即左上角开始，因此只需找到所有自增操作叠加区域，计算个数便是最大值个数
     * 时间复杂度: T(n) = O(x) x为ops操作次数
     * 空间复杂度: S(n) = O(1) 原二维数组上操作
     */
    public static int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
