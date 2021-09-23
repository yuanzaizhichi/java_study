package com.cxf.leetcode.array.p_8_前缀和数组;

public class Q_304 {
    public static void main(String[] args) {
        int[][] arr = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(arr);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    /**
     * 解法: 每行数组采用前缀和
     * 时间复杂度: T(n) = O(nm)
     * 空间复杂度: S(n) = O(nm)
     */
    static class NumMatrix {
        int[][] arr;

        public NumMatrix(int[][] matrix) {
            int length = matrix.length;
            int itemArrLen = matrix[0].length;
            arr = new int[length][itemArrLen];
            for (int i = 0; i < length; i++) {
                int[] itemArr = matrix[i];
                int[] newItemArr = new int[itemArrLen + 1];
                for (int j = 0; j < itemArrLen; j++) {
                    newItemArr[j + 1] = newItemArr[j] + itemArr[j];
                }
                arr[i] = newItemArr;
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            for (int i = row1; i <= row2; i++) {
                int[] itemArr = arr[i];
                res += itemArr[col2 + 1] - itemArr[col1];
            }
            return res;
        }
    }
}
