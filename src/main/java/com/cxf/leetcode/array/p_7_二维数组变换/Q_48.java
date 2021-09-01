package com.cxf.leetcode.array.p_7_二维数组变换;

public class Q_48 {
    public static void main(String[] args) throws Exception {

    }

    /**
     * 解法:使用辅助数组；根据规律原数组中[i,j]映射到90度旋转后的数组[j,n-i-1]
     * 时间复杂度: T(n) = O(n²)
     * 空间复杂度: S(n) = O(n²)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix2[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix2[i][j];
            }
        }
    }
}
