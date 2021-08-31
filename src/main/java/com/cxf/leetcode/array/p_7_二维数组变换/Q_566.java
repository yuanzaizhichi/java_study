package com.cxf.leetcode.array.p_7_二维数组变换;

import java.util.Arrays;

public class Q_566 {
    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{3, 4};
        int[][] reshape = matrixReshape(arr, 1, 4);
        for (int i : reshape[0]) {
            System.out.println(i);
        }

    }

    /**
     * 解法:将原多维数组看做一维数组，根据每维数组个数去获取和放置元素的位置
     * 时间复杂度: T(n) = O(rc)
     * 空间复杂度: S(n) = O(1)
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int arrLen = mat.length;
        int itemArrLen = mat[0].length;
        if (arrLen * itemArrLen != r * c) {
            System.out.println("变换前后元素数量不同，无法变换");
            return mat;
        }

        int[][] resArr = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            resArr[i / c][i % c] = mat[i / itemArrLen][i % itemArrLen];
        }
        return resArr;
    }
}
