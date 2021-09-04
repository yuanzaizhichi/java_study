package com.cxf.leetcode.array.p_7_二维数组变换;

public class Q_289 {
    public static void main(String[] args) throws Exception {
        gameOfLife2(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
//        gameOfLife(new int[][]{{1, 1}, {1, 0}});
    }

    /**
     * 解法:辅助二维数组
     * 时间复杂度: T(n) = O(nm)
     * 空间复杂度: S(n) = O(nm) 额外的辅助二维数组
     */
    public static void gameOfLife(int[][] board) {
        int arrLen = board.length;
        int itemArrLen = board[0].length;

        int[][] board_new = new int[arrLen][itemArrLen];

        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < itemArrLen; j++) {
                board_new[i][j] = getStat(i, j, arrLen, itemArrLen, board);
            }
        }

        //赋值到源数组
        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < itemArrLen; j++) {
                board[i][j] = board_new[i][j];
            }
        }

        int a = 1;
    }

    public static int getStat(int i, int j, int n, int m, int[][] board) {
        int val = board[i][j];
        int liveNum = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int k1 = (i - 1) + k;
                int l1 = (j - 1) + l;

                if (k1 >= 0 && l1 >= 0 && k1 < n && l1 < m) {
                    if (board[k1][l1] == 1) {
                        liveNum++;
                    }
                }
            }
        }
        //排除自己
        if (val == 1) {
            liveNum--;
        }

        //rule1
        if (liveNum < 2 && val == 1)
            return 0;

        //rule2
        if ((liveNum == 2 || liveNum == 3) && val == 1)
            return 1;

        //rule3
        if (liveNum > 3 && val == 1)
            return 0;

        //rule4
        if (liveNum == 3 && val == 0)
            return 1;

        return 0;
    }

    /**
     * 解法:使用多状态
     * 原题意只有1、0标识活、死细胞，新增状态-1：之前是活细胞->死细胞；状态2：之前是死细胞->活细胞，
     * 原地标记后，再将状态>0标记为活细胞，<0标记为死细胞，得出结果
     * <p>
     * 时间复杂度: T(n) = O(nm)
     * 空间复杂度: S(n) = O(1) 除了原数组，需要常数级别的空间放置若干变量
     */
    public static void gameOfLife2(int[][] board) {
        int arrLen = board.length;
        int itemArrLen = board[0].length;

        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < itemArrLen; j++) {
                board[i][j] = getStat2(i, j, arrLen, itemArrLen, board);
            }
        }

        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < itemArrLen; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

        int a = 1;
    }

    public static int getStat2(int i, int j, int n, int m, int[][] board) {
        int val = board[i][j];
        int liveNum = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int k1 = (i - 1) + k;
                int l1 = (j - 1) + l;

                if (k1 >= 0 && l1 >= 0 && k1 < n && l1 < m) {
                    if (board[k1][l1] == 1 || board[k1][l1] == -1) {
                        liveNum++;
                    }
                }
            }
        }
        //排除自己
        if (val == 1) {
            liveNum--;
        }

        //rule1
        if (liveNum < 2 && val == 1)
            return -1;

        //rule2
        if ((liveNum == 2 || liveNum == 3) && val == 1)
            return 1;

        //rule3
        if (liveNum > 3 && val == 1)
            return -1;

        //rule4
        if (liveNum == 3 && val == 0)
            return 2;

        return val;
    }
}
