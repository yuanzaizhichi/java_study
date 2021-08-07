package com.cxf.leetcode.array.p_6_特定顺序遍历二维数组;

import java.util.ArrayList;
import java.util.List;

public class Q_54 {
    public static void main(String[] args) throws Exception {

    }

    /**
     * 解法: 循环遍历（逐步缩圈）
     * 索引top
     * *********************
     * *                   *
     * *                   *
     * *索引left            *索引right
     * *                   *
     * *                   *
     * *                   *
     * *********************
     * 索引bottom
     * <p>
     * 时间复杂度: T(n) = O(mn)
     * 空间复杂度: S(n) = O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }
}
