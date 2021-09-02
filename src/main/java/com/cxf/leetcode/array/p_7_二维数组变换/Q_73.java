package com.cxf.leetcode.array.p_7_二维数组变换;

public class Q_73 {
    public static void main(String[] args) throws Exception {
        setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }

    /**
     * 解法:使用2个辅助数组标识为0的行和列
     * 时间复杂度: T(n) = O(mn)
     * 空间复杂度: S(n) = O(m+n)
     */
    public static void setZeroes(int[][] matrix) {
        int arrLen = matrix.length;
        int itemArrLen = matrix[0].length;

        boolean[] row = new boolean[arrLen];
        boolean[] col = new boolean[itemArrLen];

        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < itemArrLen; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < itemArrLen; j++) {
                if (row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }

        int a = 1;
    }
}
