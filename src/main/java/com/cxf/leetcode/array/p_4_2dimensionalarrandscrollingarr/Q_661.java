package com.cxf.leetcode.array.p_4_2dimensionalarrandscrollingarr;

import java.util.Arrays;

public class Q_661 {
    public static void main(String[] args) {
        int[][] ints = imageSmoother(new int[][]{new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}});
        Arrays.toString(ints);
    }

    public static int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr)
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
}
